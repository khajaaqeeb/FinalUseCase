package com.hunger.exception;

import java.util.List;

public class ErrorDetails {

	private Long errorCode;
	private List<String> errorMessages;
	
	public ErrorDetails() {
	
	}

	public ErrorDetails(Long errorCode, List<String> errorMessages) {
		super();
		this.errorCode = errorCode;
		this.errorMessages = errorMessages;
	}

	public Long getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
}
