package com.hunger.order.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hunger.order.entity.PlaceOrderEntity;
import com.hunger.order.model.CreateOrderModel;
import com.hunger.order.model.PlaceOrderDTO;
import com.hunger.order.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("/placeorder")
	public ResponseEntity<CreateOrderModel> placeOrder(@RequestBody PlaceOrderDTO placeOrder)
	{
		PlaceOrderEntity placeEntity = modelMapper.map(placeOrder, PlaceOrderEntity.class);
		CreateOrderModel createOrder= 	orderService.placeOrder(placeEntity);
		return new ResponseEntity<>(createOrder,HttpStatus.OK);
	}
}
