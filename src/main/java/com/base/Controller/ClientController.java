package com.base.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Repository.ClientRepository;
import com.base.Entities.Client;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepository;
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		try
		{
		   System.out.println("Get all Client...");
		   List<Client> listeclients = new ArrayList<>();
		   clientRepository.findAll().forEach(listeclients::add);
		   return listeclients;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@PostMapping(value = "/clients/create")
	public Client creatClient(@RequestBody Client client) {
		try
		{
		    Client newClient=new Client();
		    Client clientrt = clientRepository.save(newClient);
		    return clientrt;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") int id) {
		try
		{
		   System.out.println("Delete Client with ID = " + id + "...");
		   clientRepository.deleteById(id);
		   return new ResponseEntity<>("Client has been deleted!", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("", HttpStatus.EXPECTATION_FAILED);
		}
	}
}
