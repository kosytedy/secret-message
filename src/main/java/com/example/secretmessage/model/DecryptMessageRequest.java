package com.example.secretmessage.model;

import java.util.UUID;

public class DecryptMessageRequest {
	
	private UUID messageId;
	
	private String key;

	public DecryptMessageRequest(UUID messageId, String key) {
		super();
		this.messageId = messageId;
		this.key = key;
	}

	public UUID getMessageId() {
		return messageId;
	}

	public void setMessageId(UUID messageId) {
		this.messageId = messageId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "DecryptMessageRequest [messageId=" + messageId + ", key=" + key + "]";
	}
	
	
	
}
