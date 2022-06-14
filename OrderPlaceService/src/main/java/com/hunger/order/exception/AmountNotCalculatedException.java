package com.hunger.order.exception;

public class AmountNotCalculatedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AmountNotCalculatedException() {
		super();
	}

	public AmountNotCalculatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AmountNotCalculatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AmountNotCalculatedException(String message) {
		super(message);
	}

	
}
