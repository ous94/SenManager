package com.base.Controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Entities.Client;
import com.base.Entities.Employee;
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
	@GetMapping("/mesMessages")
	public HashSet<Messages> recevoirMessage()
	{
		try {
		System.out.println("get all messages.........");
		HashSet<Messages> listmessage = new  HashSet<Messages>();
		HashSet<Messages> listmes = new  HashSet<Messages>();
		messagesRepository.findAll().forEach(listmessage::add);
	    Iterator<Messages> it=listmessage.iterator();
	    while (it.hasNext()) {
			Messages messages = new Messages();
			Messages mes = it.next();
			messages.setEmail(mes.getEmail());
			messages.setNumero(mes.getNumero());
			messages.setTelClient(mes.getTelClient());
			messages.setNomClient(mes.getNomClient());
			messages.setMessage(mes.getMessage());
			listmes.add(messages);
			
		}
	    return listmes;
		}
	    catch(Exception e)
		{
			System.out.println("HAMMMMMMMM....");
			e.printStackTrace();
			return null;
		}
	}

}