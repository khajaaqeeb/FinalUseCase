package com.hunger.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderItemDetailsEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	private Long itemid;
	private Integer qnty;
	
	public OrderItemDetailsEntity(Long id, Long itemid, Integer qnty) {
		super();
		this.id = id;
		this.itemid = itemid;
		this.qnty = qnty;
	}
	public OrderItemDetailsEntity() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public Integer getQnty() {
		return qnty;
	}
	public void setQnty(Integer qnty) {
		this.qnty = qnty;
	}

}
