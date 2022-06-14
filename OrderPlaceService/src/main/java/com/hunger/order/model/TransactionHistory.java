package com.hunger.order.model;



import java.math.BigDecimal;
import java.time.LocalDateTime;


public class TransactionHistory {


	private Long transactionId;

	private String accountNumber;

	private BigDecimal transactionAmount;

	
	private LocalDateTime transactionDateTime;

	public TransactionHistory( String accountNumber, BigDecimal transactionAmount,
			LocalDateTime localDateTime) {
		super();

		this.accountNumber = accountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDateTime = localDateTime;
	}

	public TransactionHistory() {
		super();
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	

}
