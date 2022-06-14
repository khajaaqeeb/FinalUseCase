package com.hunger.order.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hunger.order.entity.CreateOrderEntity;
import com.hunger.order.entity.OrderItemDetailsEntity;
import com.hunger.order.entity.PlaceOrderEntity;
import com.hunger.order.exception.AmountNotCalculatedException;
import com.hunger.order.exception.OrderNotPlacedException;
import com.hunger.order.feignclient.PaymentClient;
import com.hunger.order.feignclient.SearchFoodClient;
import com.hunger.order.model.CreateOrderModel;
import com.hunger.order.model.PlaceOrderRequest;
import com.hunger.order.model.PlaceOrderResponse;
import com.hunger.order.model.TransactionHistory;
import com.hunger.order.model.TransferBalanceRequestEntity;
import com.hunger.order.repo.CreateOrderRepository;
import com.hunger.order.repo.PlaceOrderRepository;
import com.hunger.order.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

	@Value("${hunger.account.number}")
	private String toAccount ="12";

	@Autowired
	SearchFoodClient feignClient;

	@Autowired	
	PaymentClient paymentClient;

	@Autowired
	PlaceOrderRepository placeOrderRepo;

	@Autowired
	CreateOrderRepository createRepo;

	@Autowired
	ModelMapper modelMapper;


	@Override
	public CreateOrderModel placeOrder(PlaceOrderEntity placeOrder) {

		//Calculate the total amount for order.
		List<OrderItemDetailsEntity> orderList = placeOrder.getItemDetails();

		ResponseEntity<Integer> totalAmount = feignClient.getTotalAmount(orderList);

		if(!totalAmount.getStatusCode().is2xxSuccessful())
		{
			throw new AmountNotCalculatedException("Amount is not calculated for order items.");
		}
		PlaceOrderResponse response = new PlaceOrderResponse();
		response.setAmount(totalAmount.getBody());

		PlaceOrderRequest request = new  PlaceOrderRequest();
		request.setPlaceOrderResponse(response);

		TransferBalanceRequestEntity transfer =
				new TransferBalanceRequestEntity(placeOrder.getFromAccountNumber()+"", toAccount, new BigDecimal( request.getPlaceOrderResponse().getAmount()));
		
		ResponseEntity<TransactionHistory> history = paymentClient.sendMoney(transfer);

		if(history.getStatusCode().is2xxSuccessful())
		{

			CreateOrderEntity orderCreated = createOrder(history.getBody(), placeOrder);

			if(orderCreated!=null)
			{
				//save logic

				placeOrder.setToAccountNumber(toAccount);  
				placeOrderRepo.save(placeOrder);
				createRepo.save(orderCreated);

				CreateOrderModel orderModel = modelMapper.map(orderCreated, CreateOrderModel.class);
				orderModel.setOrderItem(placeOrder.getItemDetails());
				orderModel.setTotalAmount(new BigDecimal(request.getPlaceOrderResponse().getAmount()));
				return orderModel;
			}else {
				//revert the transaction
				throw new OrderNotPlacedException("Payment deducted but order not placed");
			}

		}
		 throw new OrderNotPlacedException("Payment failed for the order");
	}

	@Override
	public CreateOrderEntity createOrder(TransactionHistory history,PlaceOrderEntity placeOrder)
	{
		String orderId =String.valueOf( history.getTransactionId());
		return new CreateOrderEntity( orderId, history.getTransactionId(),history.getTransactionAmount(), LocalDateTime.now());
	}


}
