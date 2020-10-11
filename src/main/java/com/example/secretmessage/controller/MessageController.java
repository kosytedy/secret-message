package com.example.secretmessage.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.secretmessage.model.Message;
import com.example.secretmessage.model.DecryptMessageRequest;
import com.example.secretmessage.model.EncryptMessageRequest;
import com.example.secretmessage.repository.MessageRepository;

import net.minidev.json.JSONObject;

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
	public ResponseEntity<?> decryptMessage(@RequestBody DecryptMessageRequest request) {
		Optional<Message> message = messageRepo.findFirstByMessage(request.getMessage());
		JSONObject body = new JSONObject();
		if(message.isPresent()) {
			Message m = message.get();
			Crypter crypter = new Crypter(request.getKey());
			String decryptedMessage = crypter.decrypt(m.getMessage());
			
			body.put("decryptedMessage", decryptedMessage);
			return ResponseEntity.ok(body);
		} else {
			Map<String, String> errors = new HashMap<String,String>();
			errors.put("error", "Invalid message.");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
		}
	}
	
}
