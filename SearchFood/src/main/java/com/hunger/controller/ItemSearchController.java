package com.hunger.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hunger.entity.Items;
import com.hunger.entity.OrderItemDetailsEntity;
import com.hunger.model.ItemSearchModel;
import com.hunger.service.ItemSearchService;

@RestController
@RequestMapping("/api/v1/items")
public class ItemSearchController {

	@Autowired
	ItemSearchService itemSearch;

	@Autowired
	ModelMapper modelMapper;


	@GetMapping("/search")
	public ResponseEntity<List<ItemSearchModel>> searchProducts(@RequestParam("query") String query){
		
		List<Items> itemsEntity = itemSearch.findByCategoriesLike(query);
		
		List<ItemSearchModel> dtos = itemsEntity
				  .stream()
				  .map(user -> modelMapper.map(user, ItemSearchModel.class))
				  .collect(Collectors.toList());
		
		
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@PostMapping("/TotalAmount")
	public ResponseEntity<Integer> getTotalAmount(@RequestBody List<OrderItemDetailsEntity> orderDetails)
	{
		return new ResponseEntity<>(itemSearch.totalAmount(orderDetails),HttpStatus.OK);
	}
}
