package com.residencia.dell.exceptions;

public class ArquivosException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ArquivosException() {
		super();
	}

	public ArquivosException(String message) {
		super(message);
	}

	public ArquivosException(String message, Exception cause) {
		super(message, cause);
	}

	public ArquivosException(Exception e) {
		super(e);
	}

}
