package com.hunger.order.feignclient;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hunger.order.entity.OrderItemDetailsEntity;



@org.springframework.cloud.openfeign.FeignClient
(value = "spring-Food-service", url = "http://localhost:8091/FoodSearch/api/v1/items")
public interface SearchFoodClient {

	@PostMapping("/TotalAmount")
	public ResponseEntity<Integer> getTotalAmount(@RequestBody List<OrderItemDetailsEntity> orderDetails);
	
}
