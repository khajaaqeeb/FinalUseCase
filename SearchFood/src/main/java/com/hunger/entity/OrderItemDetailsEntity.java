package com.hunger.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItemDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long itemid;
	private Integer qnty;
	
	public OrderItemDetailsEntity(Long itemid, Integer qnty) {
		this.itemid = itemid;
		this.qnty = qnty;
	}
	public OrderItemDetailsEntity() {
		super();
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
