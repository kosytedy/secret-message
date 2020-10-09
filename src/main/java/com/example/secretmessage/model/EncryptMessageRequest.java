package com.example.secretmessage.model;

public class EncryptMessageRequest {
	
	private String rawMessage;
	
	private String key;

	public EncryptMessageRequest(String rawMessage, String key) {
		super();
		this.rawMessage = rawMessage;
		this.key = key;
	}

	public String getRawMessage() {
		return rawMessage;
	}

	public void setRawMessage(String rawMessage) {
		this.rawMessage = rawMessage;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "MessageRequest [rawMessage=" + rawMessage + ", key=" + key + "]";
	}
	
}
