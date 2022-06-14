package com.hunger.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemSearchModel {
	private Long itemid;
	private String itemname;
	private String itemdescription ;
	private BigDecimal amount;
	private String categories;
	private LocalDateTime localdatetime;
	public ItemSearchModel() {
	}
	public ItemSearchModel(Long itemid, String itemname, String itemdescription, BigDecimal amount, String categories,
			LocalDateTime localdatetime) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemdescription = itemdescription;
		this.amount = amount;
		this.categories = categories;
		this.localdatetime = localdatetime;
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
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
