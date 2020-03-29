package com.revature.coursems.exception;

public class BusinessServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	public BusinessServiceException(String message) {
		super(message);
	}
	public BusinessServiceException(String message,Throwable t) {
		super(message,t);
	}

}
