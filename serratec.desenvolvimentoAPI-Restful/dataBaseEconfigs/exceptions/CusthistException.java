package com.residencia.dell.exceptions;

public class CusthistException extends Exception{

	private static final long serialVersionUID = 1L;

	public CusthistException() {}

	public CusthistException(String message) {
			super(message);
	}

	public CusthistException(Throwable cause) {
			super(cause);
	}

	public CusthistException(String message, Throwable cause) {
			super(message, cause);
	}

	public CusthistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
