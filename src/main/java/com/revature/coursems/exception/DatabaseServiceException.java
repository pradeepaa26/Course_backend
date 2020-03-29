package com.revature.coursems.exception;

public class DatabaseServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DatabaseServiceException(String message) {
		super(message);
	}

	public DatabaseServiceException(String message,Throwable t) {
		super(message,t);
	}
}
