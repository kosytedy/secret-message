package com.example.secretmessage.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.secretmessage.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
	
	public Optional<Message> findFirstByMessage(String message);
}
