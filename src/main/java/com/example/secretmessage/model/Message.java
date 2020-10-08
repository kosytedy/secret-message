package com.example.secretmessage.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String message;
	
	@Column(name="created_at", nullable=false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	public Message() {
		super();
	}

	public Message(Long id, String message, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.message = message;
		this.createdAt = createdAt;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", createdAt=" + createdAt + "]";
	}


}
