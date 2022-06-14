package com.hunger.order.history.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hunger.order.history.entity.CreateOrderEntity;
import com.hunger.order.history.exception.OrderHistoryNotFoundException;
import com.hunger.order.history.service.OrderHistoryService;

@RestController
@RequestMapping("/api/v1/history")
public class OrderHistoryController {

	@Autowired
	OrderHistoryService orderHistory;

	@GetMapping("/latest5transaction")
	public ResponseEntity<List<CreateOrderEntity>> getLatestTransaction()
	{
		List<CreateOrderEntity> list = orderHistory.findTop5ByOrderByIdDesc();
		return new ResponseEntity<List<CreateOrderEntity>>(list,HttpStatus.OK);

	}
}
