package com.springboot.app.response;

import java.util.Collections;
import java.util.List;

public class ErrorResponse {
	
	private String code;
    private List<String> messages;
	public ErrorResponse(String code, String message) {
		super();
		this.code = code;
		this.messages = Collections.singletonList(message);;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
    
    

}
