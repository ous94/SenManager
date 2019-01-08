package com.base.Controller;

import javax.mail.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Entities.Message;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class MessageController {
	
	@PostMapping("/message/send")
	public ResponseEntity<String> sendMessage(@PathVariable("message") Message message)
	{
		try
		{
			
			return new ResponseEntity<String>("1",HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("0", HttpStatus.EXPECTATION_FAILED);
		}
	}

}
