package com.springboot.app.exception;

public class LeadAlreadyExistsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;

    public LeadAlreadyExistsException(String message) {
        super(message);
        this.errorCode = "E10010"; // Default error code for Lead Already Exists
    }

    public LeadAlreadyExistsException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


}
