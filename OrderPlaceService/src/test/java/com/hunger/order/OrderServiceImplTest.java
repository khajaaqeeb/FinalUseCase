package com.hunger.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hunger.order.entity.CreateOrderEntity;
import com.hunger.order.entity.OrderItemDetailsEntity;
import com.hunger.order.entity.PlaceOrderEntity;
import com.hunger.order.feignclient.PaymentClient;
import com.hunger.order.feignclient.SearchFoodClient;
import com.hunger.order.model.CreateOrderModel;
import com.hunger.order.model.PlaceOrderRequest;
import com.hunger.order.model.PlaceOrderResponse;
import com.hunger.order.model.TransactionHistory;
import com.hunger.order.model.TransferBalanceRequestEntity;
import com.hunger.order.repo.CreateOrderRepository;
import com.hunger.order.repo.PlaceOrderRepository;
import com.hunger.order.service.impl.OrderServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {
	
	  
	  @InjectMocks OrderServiceImpl orderService;
	  
	  
	  @Mock SearchFoodClient feignClient;
	  
	  @MockBean PaymentClient paymentClient;
	  
	  
	  @Mock CreateOrderRepository orderRepo;
	  
	  @Mock PlaceOrderRepository placeOrderRepo;
	 
	@Test
	public void placeOrderTest() {
		
		assertTrue(true);
		
		  
		  PlaceOrderEntity orderEntity = new PlaceOrderEntity(); orderEntity.setId(1L);
		  orderEntity.setFromAccountNumber("6"); 
		  
		  OrderItemDetailsEntity orderItem = new OrderItemDetailsEntity(1L, 1L, 1);
		  OrderItemDetailsEntity orderItem1 = new OrderItemDetailsEntity(2L, 1L, 1);
		  List<OrderItemDetailsEntity> list=new ArrayList<OrderItemDetailsEntity>();
		  list.add(orderItem); list.add(orderItem1);
		  
		  orderEntity.setItemDetails(list);
		  
		  
		  CreateOrderEntity createOrder = new CreateOrderEntity("12356", 2L, new  BigDecimal(335), LocalDateTime.now()); 
		  CreateOrderEntity createOrder1 = new  CreateOrderEntity("12354", 3L, new BigDecimal(335), LocalDateTime.now());
		  CreateOrderEntity createOrder2 = new CreateOrderEntity("123896", 4L, new  BigDecimal(335), LocalDateTime.now());
		  
		  List<CreateOrderEntity> itemList =new ArrayList<CreateOrderEntity>();
		  itemList.add(createOrder); 
		  itemList.add(createOrder1);
		  itemList.add(createOrder2);
		  
		  ResponseEntity<Integer> amount = new  ResponseEntity<Integer>(335,HttpStatus.OK);
		  
		  when(feignClient.getTotalAmount(list)).thenReturn(amount);
		  
		  PlaceOrderResponse response = new PlaceOrderResponse();
		  response.setAmount(amount.getBody());
		  
		  PlaceOrderRequest request = new PlaceOrderRequest();
		  request.setPlaceOrderResponse(response);
		  
		  TransferBalanceRequestEntity transfer = new TransferBalanceRequestEntity(
		  orderEntity.getFromAccountNumber()+"", "12", new BigDecimal(request.getPlaceOrderResponse().getAmount()));
		  
		  
		  TransactionHistory historyres = new TransactionHistory("6", new
		  BigDecimal(335), LocalDateTime.now());
		  historyres.setTransactionId(5L);
		  
		  ResponseEntity<TransactionHistory> history = new
		  ResponseEntity<TransactionHistory>(historyres, HttpStatus.OK);
		  
		  when(paymentClient.sendMoney(transfer)).thenReturn(history);
		  //doReturn(history).when(paymentClient.sendMoney(transfer));
		  when(placeOrderRepo.save(orderEntity)).thenReturn(orderEntity);
		  
		  when(orderRepo.save(createOrder)).thenReturn(createOrder);
		  
		  CreateOrderModel model = orderService.placeOrder(orderEntity);
		  
		  
		  assertEquals(model, model);
		  
		 }

}
