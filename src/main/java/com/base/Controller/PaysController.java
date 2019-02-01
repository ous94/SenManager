package com.base.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

import com.base.Entities.Employee;
import com.base.Entities.Pays;
import com.base.Repository.PaysRepository;

import javassist.expr.NewArray;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class PaysController {
	
	@Autowired 
	PaysRepository paysRepository;
	
	@PostMapping(value = "/pays/create")
	public Pays createEthnie(@RequestBody Pays pays ) {
		try
		{
			   System.out.println("creation  pays...");	
			   Boolean veri = findByPaysLocale(pays.getNom());
			   
			   if(veri== true)
			   {
				   return null;

				   
			   }
			   else {
                  Pays  pays2 = new Pays();
				  pays2.setNom(pays.getNom());
			      paysRepository.save(pays2);
				  return pays2;
			   
				
			   }
			   
		}catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}
	//fonction locale
		public Boolean findByPaysLocale( String nom) {
			try {
			System.out.println("recherche pays "+nom);

	 
			List<Pays> customers =  paysRepository.findByNom(nom);
			if(customers.size()==0)
			{
				return false;
			}
			else
				
			return true;
			
			}
	    	catch(Exception e)
	    	{
	    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	    		e.printStackTrace();
	    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");

	    		return false;
	    	}
		}
	
	@PutMapping("/pays/edite/{id}")
	public ResponseEntity<Pays> updateCustomer(@PathVariable("id") int id, @RequestBody Pays pays) {
		try
		{
		    System.out.println("Update pays with ID = " + id + "...");
		    Optional<Pays> paysData = paysRepository.findById(id);
			    List<Pays> cop = paysRepository.findByNom(pays.getNom());
			    if(cop.size()>0)
			    {
			    	return null;
			    }
			    else if (paysData.isPresent()) {
			    	Pays _competence = paysData.get();
			     _competence.setIdpays(id);
			     _competence.setNom(pays.getNom());;
			     _competence.setEmployees(null);
			     _competence.setClients(null);
			     return ResponseEntity.status(HttpStatus.OK).body(paysRepository.save(_competence));
		    }
		    
		    else {
			    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
		}
		
}
	@SuppressWarnings("deprecation")
	@GetMapping("/pays/pagination/{offset}")
	public List<Pays> getAllCompPagination(@PathVariable("offset")int offset) {
		try
		{
		   System.out.println("...");
		   List<Pays> listeCompetence = new ArrayList<>();
		   paysRepository.mesPays(new PageRequest(offset,5)).forEach(listeCompetence::add);
		   for(int  i=0;i< listeCompetence.size();i++)
		   {
			  // Employee employee = new Employee();
			   
			   listeCompetence.get(i).setEmployees(null);
			   listeCompetence.get(i).setClients(null);
			   
			   
		   }
		   return listeCompetence;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	
	
	@GetMapping("/pays")
	public List<Pays> getAllPays() {
		try
		{
		   System.out.println("Get all Pays...");
		   List<Pays> listepays = new ArrayList<>();
		   paysRepository.findAll().forEach(listepays::add);
		   return listepays;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@PostMapping(value = "/pays/new/create")
	public Pays creatPays(@RequestBody Pays pays) {
		try
		{
		    Pays newPays=new Pays();
		    Pays paysrt = paysRepository.save(newPays);
		    return paysrt;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@DeleteMapping("/pays/delete/{id}")
	public ResponseEntity<String> deletePays(@PathVariable("id") int id) {
		try
		{
		   System.out.println("Delete Pays with ID = " + id + "...");
		   paysRepository.deleteById(id);
		   return new ResponseEntity<>("Pays has been deleted!", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("", HttpStatus.EXPECTATION_FAILED);
		}
	}
    // list des noms des pays
    @GetMapping("/pays/nom")
    public List<String> getAllPaysnom() 
    {
     try
     {
       System.out.println("Get all Pays.nom...");
       List<Pays> listepays = new ArrayList<>();
       paysRepository.findAll().forEach(listepays::add);
       List<String> nompays = new ArrayList<>();
       Iterator<Pays> it= listepays.iterator();
       while(it.hasNext())
        {
    		nompays.add(it.next().getNom());	     
    	}
    		   return nompays;
     }
     catch(Exception e)
     {
    	return null;
     }
   }
        	
   @GetMapping("/pays/nom/{nom}")
    public List<String> getAllnomPays(@PathVariable("nom") String nom) 
   {
      try
      {
    	 System.out.println("Get all Pays.nom...");
    	 List<Pays> listePays = new ArrayList<>();
    	 paysRepository.findByNom(nom).forEach(listePays::add);
    	 List<String> nompays = new ArrayList<>();
    	 Iterator<Pays> it= listePays.iterator();
    	 while(it.hasNext())
    	 {
    		 nompays.add(it.next().getNom());  
    	 }
    	 return nompays;
       }
       catch(Exception e)
       {
    		return null;
       }
    }
    	
    //recherher nom
    @GetMapping("/ppays/nompays/{nom}")
    public Pays getPaysByNom(@PathVariable("nom") String nom)
    {
       try
       {
           System.out.println("Get all Pays.nom...");
     	   List<Pays> listePays = new ArrayList<>();
     	   paysRepository.findByNom(nom).forEach(listePays::add);
     	   Iterator<Pays> it= listePays.iterator();
     	   Pays pays= new Pays();
     	   Pays monPays=  it.next();
	       pays.setIdpays(monPays.getIdpays());
		   pays.setNom(monPays.getNom());
		   return pays;
			   
     	  		  
        }
        catch(Exception e)
        {
        	return null;
        }
     }
  //recherhe  Employer par niveau Etude
  	@GetMapping("/employes/pays/{description}")
  	 public List<Employee> getComptenceByEmploeyee(@PathVariable("description") String description)
  	 {
  	    try
  	    {
  	       System.out.println("Get Comptence.description...");
  	 	   List<Pays> listeCompetence = new ArrayList<>();
  	 	   paysRepository.findByNom(description).forEach(listeCompetence::add);
  	 	   Iterator<Pays> it= listeCompetence.iterator();
  	 	   HashSet<Employee> setEmployer= new HashSet <Employee>();
  	 	   while(it.hasNext())
  	 	   {
  	 		   Pays competence= it.next();
  	 		   setEmployer.addAll(competence.getEmployees());
  	 	   }
  	       Iterator<Employee> monit =setEmployer.iterator();
  	       List<Employee> maliste =new ArrayList<>();
  	       while(monit.hasNext())
  	 	   {
  	    	   
  	 		  Employee employee = new Employee();
  	 		 Employee emp=monit.next();
  	 		   employee.setIdemploye(emp.getIdemploye());
  			   employee.setAdresse(emp.getAdresse());
  			   employee.setDateNaissance(emp.getDateNaissance());
  			   employee.setEmail(emp.getEmail());
  			   employee.setIdentification(emp.getIdentification());
  			   employee.setNom(emp.getNom());
  			   employee.setObservation(emp.getObservation());
  			   employee.setPhoto(emp.getPhoto());
  			   employee.setPrenom(emp.getPrenom());
  			   employee.setTelephoneFixe(emp.getTelephoneFixe());
  			   employee.setTelephoneMobile(emp.getTelephoneMobile());
  			   employee.setReligion(emp.getReligion());
  			   employee.setSituationMatrimoniale(emp.getSituationMatrimoniale());
  			   maliste.add(employee);
  	 	   }
  	       return maliste;
  	       
  	       
  	    }
  	    	
  	    catch(Exception e)
  	    {
  	       System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
  	    	e.printStackTrace();
  	    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
  	    	return null;
  	    }
  	}
  //conter
  		@GetMapping("/pays/nombre")				
  		public int conter()
  		{
  		try {
  				int nombre = (int) paysRepository.count();
  				if(nombre<0)
  				{
  					return 0;
  				}else
  				   return nombre;
  				
  			} catch (Exception e) {
  				e.printStackTrace();
  				return 0;
  			}
  		}

 }
