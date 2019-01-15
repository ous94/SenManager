package com.base.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Entities.Messages;
import com.base.Repository.MessagesRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	 MessagesRepository messagesRepository;
	@PostMapping("/messages/send")
	public ResponseEntity<String> sendMessage(@RequestBody Messages messages)
	{
		
		try
		{
			  messagesRepository.save(messages);
		      return new ResponseEntity<String>("1",HttpStatus.OK);
		 }
		 
		catch(Exception e)
		{
			System.out.println("HAMMMMMMMM....");
			e.printStackTrace();
			return new ResponseEntity<String>("0", HttpStatus.EXPECTATION_FAILED);
		}
	}

}