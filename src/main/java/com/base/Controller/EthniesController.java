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
import com.base.Entities.Ethnies;
import com.base.Repository.EthniesRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class EthniesController {
	
	@Autowired
	EthniesRepository ethniesRepository;
	
	@PostMapping(value = "/ethnies/create")
	public Ethnies createEthnie(@RequestBody Ethnies ethnies) {
		try
		{
			   System.out.println("creation  competence...");
			   if(findByEthniesLocale(ethnies.getNom()))
			   {
				   return null;
			   }
			   else {
				   Ethnies  ethnies2 = new Ethnies();
			   
				   ethnies2.setNom(ethnies.getNom());
			   ethniesRepository.save(ethnies2);
			   }
			   
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ethnies;
	}
	
	//fonction locale
	public Boolean findByEthniesLocale( String nom) {
		try {
		System.out.println("recherche compentence "+nom);

 
		List<Ethnies> customers =  ethniesRepository.findByNom(nom);
		if(customers.size()==0)
		{
			return false;
		}
		return true;
		}
    	catch(Exception e)
    	{
    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
    		e.printStackTrace();
    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");

    		return null;
    	}
	}
	// edition
	
	@PutMapping("/ethnies/edite/{id}")
	public ResponseEntity<Ethnies> updateCustomer(@PathVariable("id") int id, @RequestBody Ethnies ethnies) {
		try
		{
		    System.out.println("Update ethnies with ID = " + id + "...");
		    Optional<Ethnies> competenceData = ethniesRepository.findById(id);
			    List<Ethnies> cop = ethniesRepository.findByNom(ethnies.getNom());
			    if(cop.size()>0)
			    {
			    	return null;
			    }
			    else if (competenceData.isPresent()) {
			     Ethnies _competence = competenceData.get();
			     _competence.setIdethnies(id);
			     _competence.setNom(ethnies.getNom());;
			     _competence.setEmployees(null);
			     return ResponseEntity.status(HttpStatus.OK).body(ethniesRepository.save(_competence));
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
	@GetMapping("/ethnies/pagination/{offset}")
	public List<Ethnies> getAllCompPagination(@PathVariable("offset")int offset) {
		try
		{
		   System.out.println("...");
		   List<Ethnies> listeCompetence = new ArrayList<>();
		   ethniesRepository.mesEthnies(new PageRequest(offset,5)).forEach(listeCompetence::add);
		   for(int  i=0;i< listeCompetence.size();i++)
		   {
			  // Employee employee = new Employee();
			   
			   listeCompetence.get(i).setEmployees(null);
		   }
		   return listeCompetence;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	
	@GetMapping("/ethnies")
	public List<Ethnies> getAllEthnies() {
		try
		{
		   System.out.println("Get all Ethnies...");
		   List<Ethnies> listeEthnies = new ArrayList<>();
		   ethniesRepository.findAll().forEach(listeEthnies::add);
		   return listeEthnies;
		}
		catch(Exception e)
		{
			e.printStackTrace();

			return null;
		}
	}
	@PostMapping(value = "/ethnies/new/create")
	public Ethnies creatClient(@RequestBody Ethnies ethnies) {
		try
		{
		    Ethnies newEthnies=new Ethnies();
		    Ethnies ethniesrt = ethniesRepository.save(newEthnies);
		    return ethniesrt;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@DeleteMapping("/ethnies/delete/{id}")
	public ResponseEntity<String> deleteEthnies(@PathVariable("id") int id) {
		try
		{
		   System.out.println("Delete Ethnie with ID = " + id + "...");
		   ethniesRepository.deleteById(id);
		   return new ResponseEntity<>("Client has been deleted!", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("", HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/ethnies/nom")
	public List<String> getAllnomEthnies() {
		try
		{
		   System.out.println("Get all Ethnies...");
		   List<Ethnies> listeEthnies = new ArrayList<>();
		   ethniesRepository.findAll().forEach(listeEthnies::add);
		   List<String> nomethnies = new ArrayList<>();
		   Iterator<Ethnies> it= listeEthnies.iterator();
		   while(it.hasNext())
		   {
			   nomethnies.add(it.next().getNom());
			   
			   
		   }
		   return nomethnies;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/ethnies/nom/{nom}")
	public List<String> getAllnomEthnies(@PathVariable("nom") String nom) {
		try
		{
		   System.out.println("Get all Ethnies.nom...");
		   List<Ethnies> listeEthnies = new ArrayList<>();
		   ethniesRepository.findByNom(nom).forEach(listeEthnies::add);
		   List<String> nomethnies = new ArrayList<>();
		   Iterator<Ethnies> it= listeEthnies.iterator();
		   while(it.hasNext())
		   {
			   nomethnies.add(it.next().getNom());
			   
			   
		   }
		   return nomethnies;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/eethnies/nom/{nom}")
	public Ethnies getEthniesByNom(@PathVariable("nom")String nom)
	{
		try
		{
			List<Ethnies> listeEthnies = new ArrayList<>();
			 ethniesRepository.findByNom(nom).forEach(listeEthnies::add);
			 Iterator<Ethnies> it= listeEthnies.iterator();
			 Ethnies ethnies=it.next();
			 Ethnies monEthnies=new Ethnies();
			 monEthnies.setIdethnies(ethnies.getIdethnies());
			 monEthnies.setNom(ethnies.getNom());
			 return monEthnies;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	 //recherhe  Employer par niveau Etude
  	@GetMapping("/employes/ethnies/{description}")
  	 public List<Employee> getComptenceByEmploeyee(@PathVariable("description") String description)
  	 {
  	    try
  	    {
  	       System.out.println("Get Comptence.description...");
  	 	   List<Ethnies> listeCompetence = new ArrayList<>();
  	 	   ethniesRepository.findByNom(description).forEach(listeCompetence::add);
  	 	   Iterator<Ethnies> it= listeCompetence.iterator();
  	 	   HashSet<Employee> setEmployer= new HashSet <Employee>();
  	 	   while(it.hasNext())
  	 	   {
  	 		   Ethnies competence= it.next();
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


}
