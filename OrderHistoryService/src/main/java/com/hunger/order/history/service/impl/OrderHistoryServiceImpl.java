package com.hunger.order.history.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunger.order.history.entity.CreateOrderEntity;
import com.hunger.order.history.exception.OrderHistoryNotFoundException;
import com.hunger.order.history.repo.OrderHistoryRepo;
import com.hunger.order.history.service.OrderHistoryService;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Autowired
	OrderHistoryRepo orderRepo;
	
	@Override
	public List<CreateOrderEntity> findTop5ByOrderByIdDesc() {
		Optional<List<CreateOrderEntity>> optionalList=	orderRepo.findTop5ByOrderByIdDesc();
		if(optionalList.isPresent())
		{
			return optionalList.get();
		}
		 throw new OrderHistoryNotFoundException("Order history not found for last five transactions.");
 
	}

}
