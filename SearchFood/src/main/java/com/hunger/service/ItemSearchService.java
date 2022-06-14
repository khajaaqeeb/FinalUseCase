package com.hunger.service;

import java.util.List;

import com.hunger.entity.Items;
import com.hunger.entity.OrderItemDetailsEntity;

public interface ItemSearchService {
	
	List<Items> findByCategoriesLike(String name);
	
	Integer totalAmount(List<OrderItemDetailsEntity> orderItem);
	
}
