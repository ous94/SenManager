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
import com.base.Entities.Localite;
import com.base.Repository.LocaliteRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class LocaliteController {

	@Autowired
	LocaliteRepository localiteRepository;
	@GetMapping("/localites")
	public List<Localite> getAllClients() {
		try
		{
		   System.out.println("Get all Localites...");
		   List<Localite> localites = new ArrayList<>();
		   localiteRepository.findAll().forEach(localites::add);
		   return localites;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@DeleteMapping("/localite/delete/{id}")
	public ResponseEntity<String> deleteLocalite(@PathVariable("id") int id) {
		try
		{
		   System.out.println("Delete Localite with ID = " + id + "...");
		   localiteRepository.deleteById(id);
		   return new ResponseEntity<>("Localite has been deleted!", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("", HttpStatus.EXPECTATION_FAILED);
		}
	}
	@GetMapping("/localites/nom/{nom}")
	public List<String> getAllnomLocalite(@PathVariable("nom") String nom) {
		try
		{
		   System.out.println("Get all Localite.nom...");
		   List<Localite> listeLocalite = new ArrayList<>();
		   localiteRepository.findByNom(nom).forEach(listeLocalite::add);
		   List<String> nomlocalite = new ArrayList<>();
		   Iterator<Localite> it= listeLocalite.iterator();
		   while(it.hasNext())
		   {
			   nomlocalite.add(it.next().getNom());
			   
			   
		   }
		   return nomlocalite;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/localites/nom")
	public List<String> getAllLocalitenom() {
		try
		{
		   System.out.println("Get all Localite.nom...");
		   List<Localite> listeLocalite = new ArrayList<>();
		   localiteRepository.findAll().forEach(listeLocalite::add);
		   List<String> nomlocalite = new ArrayList<>();
		   Iterator<Localite> it= listeLocalite.iterator();
		   while(it.hasNext())
		   {
			   nomlocalite.add(it.next().getNom());
			   
			   
		   }
		   return nomlocalite;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@GetMapping("/llocalite/nom/{nom}")
	public Localite getLocaliteByNom(@PathVariable("nom") String nom)
	{
		try
		{
			List<Localite> listeLocalite = new ArrayList<>();
			localiteRepository.findByNom(nom).forEach(listeLocalite::add);
			Iterator<Localite> it= listeLocalite.iterator();

			Localite localite=it.next();
			Localite malocalite=new Localite();
			malocalite.setIdlocalite(localite.getIdlocalite());
			malocalite.setNom(localite.getNom());
			return malocalite;
			
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	 //recherhe  Employer par localite
  	@GetMapping("/employes/localite/{description}")
  	 public List<Employee> getComptenceByEmploeyee(@PathVariable("description") String description)
  	 {
  	    try
  	    {
  	       System.out.println("Get Comptence.description...");
  	 	   List<Localite> listeCompetence = new ArrayList<>();
  	 	   localiteRepository.findByNom(description).forEach(listeCompetence::add);
  	 	   Iterator<Localite> it= listeCompetence.iterator();
  	 	   HashSet<Employee> setEmployer= new HashSet <Employee>();
  	 	   while(it.hasNext())
  	 	   {
  	 		   Localite competence= it.next();
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
  	//creation Localite
  	@PostMapping(value = "/localite/create")
	public Ethnies createEthnie(@RequestBody Ethnies ethnies) {
		try
		{
			   System.out.println("creation  localite...");
			   if(findByEthniesLocale(ethnies.getNom()))
			   {
				   return null;
			   }
			   else {
				   Localite  ethnies2 = new Localite();
			   
				   ethnies2.setNom(ethnies.getNom());
			   localiteRepository.save(ethnies2);
			   }
			   
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ethnies;
	}
	
	//fonction locale
	public Boolean findByEthniesLocale( String nom) {
		try {
		System.out.println("recherche localite "+nom);

 
		List<Localite> customers =  localiteRepository.findByNom(nom);
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
	
	@PutMapping("/localite/edite/{id}")
	public ResponseEntity<Localite> updateCustomer(@PathVariable("id") int id, @RequestBody Localite localite) {
		try
		{
		    System.out.println("Update ethnies with ID = " + id + "...");
		    Optional<Localite> competenceData = localiteRepository.findById(id);
			    List<Localite> cop = localiteRepository.findByNom(localite.getNom());
			    if(cop.size()>0)
			    {
			    	return null;
			    }
			    else if (competenceData.isPresent()) {
			     Localite _competence = competenceData.get();
			     _competence.setIdlocalite(id);
			     _competence.setNom(localite.getNom());;
			     _competence.setClients(null);
			     _competence.setEmployees(null);
			     return ResponseEntity.status(HttpStatus.OK).body(localiteRepository.save(_competence));
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
	@GetMapping("/localite/pagination/{offset}")
	public List<Localite> getAllCompPagination(@PathVariable("offset")int offset) {
		try
		{
		   System.out.println("...");
		   List<Localite> listeCompetence = new ArrayList<>();
		   localiteRepository.mesLocalites(new PageRequest(offset,5)).forEach(listeCompetence::add);
		   for(int  i=0;i< listeCompetence.size();i++)
		   {
			  // Employee employee = new Employee();
			   
			   listeCompetence.get(i).setEmployees(null);
		   }
		   return listeCompetence;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	//conter
			@GetMapping("/localite/nombre")				
			public int conter()
			{
			try {
					int nombre = (int) localiteRepository.count();
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
