package com.base.Controller;

import java.util.ArrayList;
import java.util.Iterator;
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
		   Iterator<Client> itClient=listeclients.iterator();
		   List<Client> maListe=new ArrayList<>();
		   Client newClient= new Client();
		   while(itClient.hasNext())
		   {
			   Client client=itClient.next();
			   newClient.setIdclient(client.getIdclient());
			   newClient.setAdresse(client.getAdresse());
			   newClient.setEmail(client.getEmail());
			   newClient.setIdentification(client.getIdentification());
			   newClient.setNom(client.getNom());
			   newClient.setObservation(client.getObservation());
			   newClient.setPrenom(client.getPrenom());
			   newClient.setSexe(client.getSexe());
			   newClient.setTelephoneFixe(client.getTelephoneFixe());
			   newClient.setTelephoneMobile(client.getTelephoneMobile());
		       maListe.add(newClient);
		   }
		   return maListe;
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
		    Client clientrt = clientRepository.save(client);
		    newClient.setIdclient(clientrt.getIdclient());
		    newClient.setAdresse(clientrt.getAdresse());
		    newClient.setEmail(clientrt.getEmail());
		    newClient.setIdentification(clientrt.getIdentification());
		    newClient.setNom(clientrt.getNom());
		    newClient.setObservation(clientrt.getObservation());
		    newClient.setPrenom(clientrt.getPrenom());
		    newClient.setSexe(clientrt.getSexe());
		    newClient.setTelephoneFixe(clientrt.getTelephoneFixe());
		    newClient.setTelephoneMobile(clientrt.getTelephoneMobile());
		    return newClient;
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
