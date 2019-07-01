package com.customerapp.exception;

public class ResponseDto {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseDto(String message) {
		super();
		this.message = message;
	}

}
