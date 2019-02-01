package com.base.Controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

import com.base.Entities.Client;
import com.base.Entities.Contrat;
import com.base.Entities.Demande;
import com.base.Entities.Employee;
import com.base.Entities.RechercheContrat;
import com.base.Repository.ContratRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class ContratController {
	
	@Autowired
	ContratRepository contratRepository;
	
	//
	@PostMapping("/contrat/create")
	public Contrat creatContrat(@RequestBody Contrat contrat)
	{
		try
		{
		  return contratRepository.save(contrat);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@DeleteMapping("/contrat/delete/{idContrat}")
	public String deleteContrat(@PathVariable("idContrat") int idContrat)
	{
		try
		{
			contratRepository.deleteById(idContrat);
			return "1";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "0";
		}
	}
	
	//
	@SuppressWarnings("deprecation")
	@GetMapping("/contrat/liste/pagination/{offset}")
	public HashSet<Contrat> findAllContratPagination(@PathVariable("offset")int offset)
	{
		try
		{
			HashSet<Contrat> listeContrat =new HashSet<Contrat>();
			HashSet<Contrat> newListeContrat =new HashSet<Contrat>();
			contratRepository.findAllContratPagination(new PageRequest(offset,5)).forEach(listeContrat::add);
			Iterator<Contrat> itContrat=listeContrat.iterator();
			while(itContrat.hasNext())
			{
				Contrat contrat=itContrat.next();
				Contrat newContrat=new Contrat();
				newContrat.setDebut(contrat.getDebut());
				newContrat.setFin(contrat.getFin());
				newContrat.setSalaire(contrat.getSalaire());
				newContrat.setIdContrat(contrat.getIdContrat());
				Employee employe= contrat.getEmployee();
				Demande demande =contrat.getDemande();
				if(employe!=null)
				{
					Employee emp =new Employee();
					emp.setNom(employe.getNom());
					emp.setPrenom(employe.getPrenom());
					emp.setAdresse(employe.getAdresse());
					emp.setDateNaissance(employe.getDateNaissance());
					emp.setTelephoneFixe(employe.getTelephoneFixe());
					emp.setTelephoneMobile(employe.getTelephoneMobile());
					emp.setEmail(employe.getEmail());
					emp.setSituationMatrimoniale(employe.getSituationMatrimoniale());
					emp.setIdemploye(employe.getIdemploye());
					emp.setIdentification(employe.getIdentification());
					newContrat.setEmployee(emp);
				}
				if(demande!=null)
				{
					Demande dmd=new Demande();
					dmd.setDate(demande.getDate());
					dmd.setIddemande(demande.getIddemande());
					dmd.setSalairePropose(demande.getSalairePropose());
					dmd.setServices(demande.getServices());
					Client client =demande.getClient();
					if(client!=null)
					{
						Client cl=new Client();
						cl.setNom(client.getNom());
						cl.setPrenom(client.getPrenom());
						cl.setTelephoneFixe(client.getTelephoneFixe());
						cl.setTelephoneMobile(client.getTelephoneMobile());
						cl.setAdresse(client.getAdresse());
						cl.setEmail(client.getEmail());
						cl.setSexe(client.getSexe());
						cl.setIdclient(client.getIdclient());
						cl.setIdentification(client.getIdentification());
						dmd.setClient(cl);
					}
					newContrat.setDemande(dmd);
				}
				newListeContrat.add(newContrat);
			}
			return newListeContrat;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//
	@GetMapping("/contrat/liste")
	public HashSet<Contrat> findAllContrat()
	{
		try
		{
			HashSet<Contrat> listeContrat =new HashSet<Contrat>();
			HashSet<Contrat> newListeContrat =new HashSet<Contrat>();
			contratRepository.findAll().forEach(listeContrat::add);
			Iterator<Contrat> itContrat=listeContrat.iterator();
			while(itContrat.hasNext())
			{
				Contrat contrat=itContrat.next();
				Contrat newContrat=new Contrat();
				newContrat.setDebut(contrat.getDebut());
				newContrat.setFin(contrat.getFin());
				newContrat.setSalaire(contrat.getSalaire());
				newContrat.setIdContrat(contrat.getIdContrat());
				Employee employe= contrat.getEmployee();
				Demande demande =contrat.getDemande();
				if(employe!=null)
				{
					Employee emp =new Employee();
					emp.setNom(employe.getNom());
					emp.setPrenom(employe.getPrenom());
					emp.setAdresse(employe.getAdresse());
					emp.setDateNaissance(employe.getDateNaissance());
					emp.setTelephoneFixe(employe.getTelephoneFixe());
					emp.setTelephoneMobile(employe.getTelephoneMobile());
					emp.setEmail(employe.getEmail());
					emp.setSituationMatrimoniale(employe.getSituationMatrimoniale());
					emp.setIdemploye(employe.getIdemploye());
					emp.setIdentification(employe.getIdentification());
					newContrat.setEmployee(emp);
				}
				if(demande!=null)
				{
					Demande dmd=new Demande();
					dmd.setDate(demande.getDate());
					dmd.setIddemande(demande.getIddemande());
					dmd.setSalairePropose(demande.getSalairePropose());
					dmd.setServices(demande.getServices());
					Client client =demande.getClient();
					if(client!=null)
					{
						Client cl=new Client();
						cl.setNom(client.getNom());
						cl.setPrenom(client.getPrenom());
						cl.setTelephoneFixe(client.getTelephoneFixe());
						cl.setTelephoneMobile(client.getTelephoneMobile());
						cl.setAdresse(client.getAdresse());
						cl.setEmail(client.getEmail());
						cl.setSexe(client.getSexe());
						cl.setIdclient(client.getIdclient());
						cl.setIdentification(client.getIdentification());
						dmd.setClient(cl);
					}
					newContrat.setDemande(dmd);
				}
				newListeContrat.add(newContrat);
			}
			return newListeContrat;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//
	@SuppressWarnings("deprecation")
	@PostMapping("/contrat/employee")
	public HashSet<Contrat> findByEmployeePagination(@RequestBody RechercheContrat rechercheContrat)
	{
		try
		{
			HashSet<Contrat> listeContrat =new HashSet<Contrat>();
			HashSet<Contrat> newListeContrat =new HashSet<Contrat>();
			contratRepository.findByEmployeePagination(rechercheContrat.getEmploye(),new PageRequest(rechercheContrat.getOffset(),5)).forEach(listeContrat::add);
			Iterator<Contrat> itContrat=listeContrat.iterator();
			while(itContrat.hasNext())
			{
				Contrat contrat=itContrat.next();
				Contrat newContrat=new Contrat();
				newContrat.setDebut(contrat.getDebut());
				newContrat.setFin(contrat.getFin());
				newContrat.setSalaire(contrat.getSalaire());
				newContrat.setIdContrat(contrat.getIdContrat());
				Employee employe= contrat.getEmployee();
				Demande demande =contrat.getDemande();
				if(employe!=null)
				{
					Employee emp =new Employee();
					emp.setNom(employe.getNom());
					emp.setPrenom(employe.getPrenom());
					emp.setAdresse(employe.getAdresse());
					emp.setDateNaissance(employe.getDateNaissance());
					emp.setTelephoneFixe(employe.getTelephoneFixe());
					emp.setTelephoneMobile(employe.getTelephoneMobile());
					emp.setEmail(employe.getEmail());
					emp.setSituationMatrimoniale(employe.getSituationMatrimoniale());
					emp.setIdemploye(employe.getIdemploye());
					emp.setIdentification(employe.getIdentification());
					newContrat.setEmployee(emp);
				}
				if(demande!=null)
				{
					Demande dmd=new Demande();
					dmd.setDate(demande.getDate());
					dmd.setIddemande(demande.getIddemande());
					dmd.setSalairePropose(demande.getSalairePropose());
					dmd.setServices(demande.getServices());
					Client client =demande.getClient();
					if(client!=null)
					{
						Client cl=new Client();
						cl.setNom(client.getNom());
						cl.setPrenom(client.getPrenom());
						cl.setTelephoneFixe(client.getTelephoneFixe());
						cl.setTelephoneMobile(client.getTelephoneMobile());
						cl.setAdresse(client.getAdresse());
						cl.setEmail(client.getEmail());
						cl.setSexe(client.getSexe());
						cl.setIdclient(client.getIdclient());
						cl.setIdentification(client.getIdentification());
						dmd.setClient(cl);
					}
					newContrat.setDemande(dmd);
				}
				newListeContrat.add(newContrat);
			}
			return newListeContrat;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//
	@SuppressWarnings("deprecation")
	@PostMapping("/contrat/demande")
	public HashSet<Contrat> findByDemandePagination(@RequestBody RechercheContrat rechercheContrat)
	{
		try
		{
			HashSet<Contrat> listeContrat =new HashSet<Contrat>();
			HashSet<Contrat> newListeContrat =new HashSet<Contrat>();
			contratRepository.findByDemandePagination(rechercheContrat.getDemande(),new PageRequest(rechercheContrat.getOffset(),5)).forEach(listeContrat::add);
			Iterator<Contrat> itContrat=listeContrat.iterator();
			while(itContrat.hasNext())
			{
				Contrat contrat=itContrat.next();
				Contrat newContrat=new Contrat();
				newContrat.setDebut(contrat.getDebut());
				newContrat.setFin(contrat.getFin());
				newContrat.setSalaire(contrat.getSalaire());
				newContrat.setIdContrat(contrat.getIdContrat());
				Demande demande =contrat.getDemande();
				if(demande!=null)
				{
					Demande dmd=new Demande();
					dmd.setDate(demande.getDate());
					dmd.setIddemande(demande.getIddemande());
					dmd.setSalairePropose(demande.getSalairePropose());
					dmd.setServices(demande.getServices());
					Client client =demande.getClient();
					if(client!=null)
					{
						Client cl=new Client();
						cl.setNom(client.getNom());
						cl.setPrenom(client.getPrenom());
						cl.setTelephoneFixe(client.getTelephoneFixe());
						cl.setTelephoneMobile(client.getTelephoneMobile());
						cl.setAdresse(client.getAdresse());
						cl.setEmail(client.getEmail());
						cl.setSexe(client.getSexe());
						cl.setIdclient(client.getIdclient());
						cl.setIdentification(client.getIdentification());
						dmd.setClient(cl);
					}
					newContrat.setDemande(dmd);
				}
				Employee employe= contrat.getEmployee();
				if(employe!=null)
				{
					Employee emp =new Employee();
					emp.setNom(employe.getNom());
					emp.setPrenom(employe.getPrenom());
					emp.setAdresse(employe.getAdresse());
					emp.setDateNaissance(employe.getDateNaissance());
					emp.setTelephoneFixe(employe.getTelephoneFixe());
					emp.setTelephoneMobile(employe.getTelephoneMobile());
					emp.setEmail(employe.getEmail());
					emp.setSituationMatrimoniale(employe.getSituationMatrimoniale());
					emp.setIdemploye(employe.getIdemploye());
					emp.setIdentification(employe.getIdentification());
					newContrat.setEmployee(emp);
				}
				newListeContrat.add(newContrat);
			}
			return newListeContrat;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	//
	@PutMapping("/contrat/edite/{id}")
	public ResponseEntity<Contrat> updateCustomer(@PathVariable("id") int id, @RequestBody Contrat contrat) {
		
		try
		{
		System.out.println("Update Contrat with ID = " + id + "...");
		Optional<Contrat> contratData = contratRepository.findById(id);
	    if (contratData.isPresent()) {
		    Contrat _contrat = contratData.get();
		    _contrat.setDebut(contrat.getDebut());
		    _contrat.setFin(contrat.getFin());
		    _contrat.setSalaire(contrat.getSalaire());
		    Contrat monContrat=contratRepository.save(_contrat);
		    Contrat newContrat=new Contrat();
		    Employee employe=monContrat.getEmployee();
		    if(employe==null)
		    {
		    	Employee emp=new Employee();
		    	newContrat.setEmployee(emp);;
		    }
		    else
		    {
		    	Employee emp=new Employee();
		    	emp.setNom(employe.getNom());
				emp.setPrenom(employe.getPrenom());
				emp.setAdresse(employe.getAdresse());
				emp.setDateNaissance(employe.getDateNaissance());
				emp.setTelephoneFixe(employe.getTelephoneFixe());
				emp.setTelephoneMobile(employe.getTelephoneMobile());
				emp.setEmail(employe.getEmail());
				emp.setSituationMatrimoniale(employe.getSituationMatrimoniale());
				emp.setIdemploye(employe.getIdemploye());
				emp.setIdentification(employe.getIdentification());
			    newContrat.setEmployee(emp);
		    }
		    
		    newContrat.setIdContrat(monContrat.getIdContrat());
		    newContrat.setDebut(monContrat.getDebut());
		    newContrat.setFin(monContrat.getFin());
		    newContrat.setSalaire(monContrat.getSalaire());
		    
			return new ResponseEntity<>(newContrat, HttpStatus.OK);
	    } 
	    else 
	    {
			return null;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
  }
  @SuppressWarnings("deprecation")
@PostMapping("/contrat/recherche")
  HashSet<Contrat> rechercheContrat(@RequestBody RechercheContrat rechercheContrat)
  {
	  try
	  {
		 Contrat contrt=rechercheContrat.getContrat() ;
		 int offset=rechercheContrat.getOffset();
		 HashSet<Contrat> listeContrats=new HashSet<Contrat>();
		 HashSet<Contrat> newListeContrat= new HashSet<Contrat>();
		 contratRepository.rechercheContratPagination(contrt.getFin(), contrt.getDebut(), contrt.getSalaire(), new PageRequest(offset,5)).forEach(listeContrats::add);
		 Iterator<Contrat> itContrat=listeContrats.iterator();
			while(itContrat.hasNext())
			{
				Contrat contrat=itContrat.next();
				Contrat newContrat=new Contrat();
				newContrat.setDebut(contrat.getDebut());
				newContrat.setFin(contrat.getFin());
				newContrat.setSalaire(contrat.getSalaire());
				newContrat.setIdContrat(contrat.getIdContrat());
				Employee employe= contrat.getEmployee();
				Demande demande =contrat.getDemande();
				if(employe!=null)
				{
					Employee emp =new Employee();
					emp.setNom(employe.getNom());
					emp.setPrenom(employe.getPrenom());
					emp.setAdresse(employe.getAdresse());
					emp.setDateNaissance(employe.getDateNaissance());
					emp.setTelephoneFixe(employe.getTelephoneFixe());
					emp.setTelephoneMobile(employe.getTelephoneMobile());
					emp.setEmail(employe.getEmail());
					emp.setSituationMatrimoniale(employe.getSituationMatrimoniale());
					emp.setIdemploye(employe.getIdemploye());
					emp.setIdentification(employe.getIdentification());
					newContrat.setEmployee(emp);
				}
				if(demande!=null)
				{
					Demande dmd=new Demande();
					dmd.setDate(demande.getDate());
					dmd.setIddemande(demande.getIddemande());
					dmd.setSalairePropose(demande.getSalairePropose());
					dmd.setServices(demande.getServices());
					Client client =demande.getClient();
					if(client!=null)
					{
						Client cl=new Client();
						cl.setNom(client.getNom());
						cl.setPrenom(client.getPrenom());
						cl.setTelephoneFixe(client.getTelephoneFixe());
						cl.setTelephoneMobile(client.getTelephoneMobile());
						cl.setAdresse(client.getAdresse());
						cl.setEmail(client.getEmail());
						cl.setSexe(client.getSexe());
						cl.setIdclient(client.getIdclient());
						cl.setIdentification(client.getIdentification());
						dmd.setClient(cl);
					}
					newContrat.setDemande(dmd);
				}
				newListeContrat.add(newContrat);
			}
			return newListeContrat;
		 
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  return null;
	  }
  }
	

}
