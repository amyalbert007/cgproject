package com.cg.onlineflatrentalapp.exception;

public class ErrorMessage {

	public ErrorMessage(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	private int errorCode;
	private String errorMessage;

	public ErrorMessage() {
		super();
	}


	public ErrorMessage(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}
