package com.example.secretmessage.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.secretmessage.model.Message;
import com.example.secretmessage.model.DecryptMessageRequest;
import com.example.secretmessage.model.EncryptMessageRequest;
import com.example.secretmessage.repository.MessageRepository;

@RestController
public class MessageController {
	
	@Autowired
	MessageRepository messageRepo;
	
	@PostMapping("/encrypt")
	public Message encryptMessage(@RequestBody EncryptMessageRequest request) {
		Crypter crypter = new Crypter(request.getKey());
		String encryptedMessage = crypter.encrypt(request.getRawMessage());
		
		Message m = new Message();
		m.setMessage(encryptedMessage);
		return messageRepo.save(m);
	}
	
	@PostMapping("/decrypt")
	public String decryptMessage(@RequestBody DecryptMessageRequest request) {
		Optional<Message> message = messageRepo.findById(request.getMessageId());
		if(message.isPresent()) {
			Message m = message.get();
			Crypter crypter = new Crypter(request.getKey());
			String decryptedMessage = crypter.decrypt(m.getMessage());
			return decryptedMessage;
		} else {
			return "Invalid message ID";
		}
	}
	
}
