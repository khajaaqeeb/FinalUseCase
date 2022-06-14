package com.hunger.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Items {

	@Id
	private Long itemid;
	private String itemname;
	private String itemdescription ;
	private Integer amount;
	private String categories;
	
	private LocalDateTime localdatetime;

	public Items(Long itemid, String itemname, String itemdescription, Integer amount, String categories,
			LocalDateTime localdatetime) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemdescription = itemdescription;
		this.amount = amount;
		this.categories = categories;
		this.localdatetime = localdatetime;
	}

	public Items() {
		super();
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemdescription() {
		return itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public LocalDateTime getLocaldatetime() {
		return localdatetime;
	}

	public void setLocaldatetime(LocalDateTime localdatetime) {
		this.localdatetime = localdatetime;
	}

	
}
