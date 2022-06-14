package com.hunger.order.service;

import com.hunger.order.entity.CreateOrderEntity;
import com.hunger.order.entity.PlaceOrderEntity;
import com.hunger.order.model.CreateOrderModel;
import com.hunger.order.model.TransactionHistory;

public interface OrderService {

	public CreateOrderModel placeOrder(PlaceOrderEntity placeOrder);
	CreateOrderEntity createOrder(TransactionHistory history,PlaceOrderEntity placeOrder);
}
