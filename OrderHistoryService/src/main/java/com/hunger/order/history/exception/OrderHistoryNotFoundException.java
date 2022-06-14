package com.hunger.order.history.exception;

public class OrderHistoryNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderHistoryNotFoundException(String Message)
	{
		super(Message);
	}
}
