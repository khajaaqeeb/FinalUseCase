package com.hunger.exception;

public class MenuItemsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuItemsNotFoundException(String message){
		super(message);
	}
}
