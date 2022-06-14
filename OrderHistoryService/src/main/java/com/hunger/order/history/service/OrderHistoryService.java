package com.hunger.order.history.service;

import java.util.List;

import com.hunger.order.history.entity.CreateOrderEntity;

public interface OrderHistoryService {

	public List<CreateOrderEntity> findTop5ByOrderByIdDesc();
}
