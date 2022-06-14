package com.hunger.order.model;

import java.math.BigDecimal;


public class TransferBalanceRequestEntity {
	
    private String fromAccountNumber;
	
    private String toAccountNumber;
	
    private BigDecimal amount;

	public TransferBalanceRequestEntity() {
	}

	public TransferBalanceRequestEntity(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
    
    

}