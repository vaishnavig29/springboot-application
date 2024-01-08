package com.springboot.app.response;

public class ApiResponse<T> {
	private String status;
    private T data;
    private String errorCode;
    private String errorMessage;
  
    
 // Constructor for success response
    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    // Constructor for error response
    public ApiResponse(String status, String errorCode, String errorMessage) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
    

}
