package com.hunger.order.model;

import java.util.List;

import com.hunger.order.entity.OrderItemDetailsEntity;

public class PlaceOrderDTO {

	private Long id;

	private String toAccountNumber;
	
	private String fromAccountNumber;
	
	private List<OrderItemDetailsEntity> itemDetails;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<OrderItemDetailsEntity> getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(List<OrderItemDetailsEntity> itemDetails) {
		this.itemDetails = itemDetails;
	}
	public String getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}


}
