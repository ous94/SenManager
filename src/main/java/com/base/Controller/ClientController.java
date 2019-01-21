package com.base.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Repository.ClientRepository;
import com.base.Entities.Client;
import com.base.Entities.Competence;
import com.base.Entities.Demande;
import com.base.Entities.Disponibilite;
import com.base.Entities.Employee;
import com.base.Entities.Ethnies;
import com.base.Entities.Langue;
import com.base.Entities.Localite;
import com.base.Entities.Niveauetude;
import com.base.Entities.Pays;
import com.base.Entities.TypeIdentification;

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
		   while(itClient.hasNext())
			   
		   {
			   Client newClient= new Client();

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
			String idString=""+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)));
            Integer id=java.lang.Integer.valueOf(idString);
            client.setIdclient(id);
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
	
	@PostMapping("/client/login")
	public  Client connexion( @RequestBody Client client)
	{
		try {
			System.out.println("login client");
			List<Client> maliste = new ArrayList<>();
			maliste = clientRepository.findByLoginAndPassword(client.getLogin(), client.getPassword());
			Iterator<Client> itclient = maliste.iterator();
			Client monClient = itclient.next();
			    Client newClient=new Client();
			    newClient.setIdclient(monClient.getIdclient());
			    newClient.setAdresse(monClient.getAdresse());
			    newClient.setEmail(monClient.getEmail());
			    newClient.setIdentification(monClient.getIdentification());
			    newClient.setNom(monClient.getNom());
			    newClient.setObservation(monClient.getObservation());
			    newClient.setPrenom(monClient.getPrenom());
			    newClient.setSexe(monClient.getSexe());
			    newClient.setTelephoneFixe(monClient.getTelephoneFixe());
			    newClient.setTelephoneMobile(monClient.getTelephoneMobile());
			
			 return newClient;
	    }
	    catch (Exception e)
		{
			return null;
		}
	}
	@PutMapping("/clients/edite/{id}")
	public ResponseEntity<Client> updateCustomer(@PathVariable("id") int id, @RequestBody Client client) {
		
		try
		{
		System.out.println("Update Customer with ID = " + id + "...");
		Optional<Client> clientData = clientRepository.findById(id);
	    if (clientData.isPresent()) {
		    Client _client = clientData.get();
		    _client.setNom(client.getNom());
		    _client.setPrenom(client.getPrenom());
		    _client.setLogin(client.getLogin());
		    _client.setPassword(client.getPassword());
		    _client.setEmail(client.getEmail());
		    _client.setLocalite(client.getLocalite());
		    
			return new ResponseEntity<>(clientRepository.save(_client), HttpStatus.OK);
	    } else {
			return null;
		}
	}catch(Exception e)
	{
		return null;
	}
  }
	
	
	//Get All Employes avec plus de Details
		@GetMapping("/clientall")
		public HashSet<Client> getAllClientss() {
			try
			{
				System.out.println("Get All Employe Detail");
			   HashSet<Client> listeClients = new HashSet<Client>();
			   HashSet<Client> listeEmp=new HashSet<Client>();
			   clientRepository.findAll().forEach(listeClients::add);
			   Iterator<Client> it=listeClients.iterator();
			    while(it.hasNext())
			   {
				   Client employee=new Client();
				   Client emp=it.next();
				   employee.setIdclient(emp.getIdclient());
				   employee.setAdresse(emp.getAdresse());
				   employee.setEmail(emp.getEmail());
				   employee.setIdentification(emp.getIdentification());
				   employee.setNom(emp.getNom());
				   employee.setObservation(emp.getObservation());
				   employee.setPrenom(emp.getPrenom());
				   employee.setTelephoneFixe(emp.getTelephoneFixe());
				   employee.setTelephoneMobile(emp.getTelephoneMobile());
				   employee.setLogin(emp.getLogin());
				   employee.setPassword(emp.getPassword());
				   Pays pays=emp.getPay();
				   Localite localites= emp.getLocalite();
				   TypeIdentification typeIdentifications =emp.getTypeIdentification();
				   
				   
				   /*while(itCompetence.hasNext())
				   {
					   Competence comp=itCompetence.next();
					   comp.setDemandes(null);
					   comp.setEmployees(null);
					   setCompetence.add(comp);
				   }
				   while(itDisponibilite.hasNext())
				   {
					   Disponibilite dispo=itDisponibilite.next();
					   dispo.setEmployee(null);
					   setDisponibilite.add(dispo);
				   }
				   while(itLangue.hasNext())
				   {
					  Langue lang=itLangue.next();
					  lang.setEmployees(null);
					  setLangue.add(lang);
				   }*/
				   Pays pys=new Pays();
				   if(pays !=null) {
				   pys.setIdpays(pays.getIdpays());
				   pys.setNom(pays.getNom());
				   }
				   TypeIdentification typ = new TypeIdentification();
				   if(typeIdentifications !=null) {
					   typ.setIdidentification(typeIdentifications.getIdidentification());
					   typ.setNom(typeIdentifications.getNom());
					   }
				   Localite loc = new Localite();
				   if(localites !=null)
				   {
					   loc.setIdlocalite(localites.getIdlocalite());
					   loc.setNom(localites.getNom());
				   }
				   employee.setPay(pys);
				   employee.setLocalite(loc);
				   employee.setTypeIdentification(typ);
				   listeEmp.add(employee);
			   }
			   return listeEmp;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
		}
}
