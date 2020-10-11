package com.example.secretmessage.model;

public class DecryptMessageRequest {
	
	private String message;
	
	private String key;

	public DecryptMessageRequest(String message, String key) {
		super();
		this.message = message;
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "DecryptMessageRequest [message=" + message + ", key=" + key + "]";
	}
	
	
	
}
