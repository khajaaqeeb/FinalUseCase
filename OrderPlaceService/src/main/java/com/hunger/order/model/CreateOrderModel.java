package com.hunger.order.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hunger.order.entity.OrderItemDetailsEntity;


public class CreateOrderModel {

	@JsonIgnore
	private Long id;
	private String orderid;
	private Long transactionId;
	private List<OrderItemDetailsEntity> orderItem;
	private BigDecimal totalAmount;
	private LocalDateTime date;
	
	public CreateOrderModel( String orderid, Long transactionId,
			BigDecimal totalAmount, LocalDateTime date) {
		super();
	
		this.orderid = orderid;
		this.transactionId = transactionId;
		
		this.totalAmount = totalAmount;
		this.date = date;
	}
	
	public CreateOrderModel() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public List<OrderItemDetailsEntity> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItemDetailsEntity> orderItem) {
		this.orderItem = orderItem;
	}
	
}
