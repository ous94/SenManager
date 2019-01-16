package com.base.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Repository.ComptenceRepository;
import com.base.Entities.Competence;
import com.base.Entities.Employee;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class CompetenceController {

	@Autowired
	ComptenceRepository competenceRepository;
	/*
	@GetMapping("/competence/description/{tabdescription}")
	public List<Competence> getBydescriptionCompetence(@PathVariable("tabdescription")String[] tabdescription) {
		try
		{
		   System.out.println("++++++");
		   List<Competence> listeCompetence = new ArrayList<>();
		  for(int i=0;i<tabdescription.length;i++)
		  {
			  competenceRepository.findByDescription(tabdescription[i]).forEach(listeCompetence::add);
			  
		  }
		  return listeCompetence;
		   
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	*/
	//Get All Competence avec plus de Details
	@GetMapping("/competences")
	public List<Competence> getAllCompetence() {
		try
		{
		   System.out.println("...");
		   List<Competence> listeCompetence = new ArrayList<>();
		   competenceRepository.findAll().forEach(listeCompetence::add);
		   for(int  i=0;i< listeCompetence.size();i++)
		   {
			   listeCompetence.get(i).setEmployees(null);
			   listeCompetence.get(i).setDemandes(null);
		   }
		   return listeCompetence;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	//
	@GetMapping("/competence/description")
	public String[] getAlldescriptionCompetence() {
		try
		{
		   System.out.println("...");
		   List<Competence> listeCompetence = new ArrayList<>();
		   competenceRepository.findAll().forEach(listeCompetence::add);
		   String[] nomCompetence=new String[listeCompetence.size()];
		   for(int  i=0;i< listeCompetence.size();i++)
		   {
			   nomCompetence[i]=listeCompetence.get(i).getDescription();
		   }
		   return nomCompetence;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	//recherher nom
	//	@GetMapping("/competence/{description}")
	
	    /*    public Competence getComptenceByDescription(String description)

		@GetMapping("/competence/description/{description}")
	        public Competence getComptenceByDescription(@PathVariable("description") String description)
	    {
	    	try
	    	{
	    	   System.out.println("Get Comptence.description...");
	 		   List<Competence> listeCompetence = new ArrayList<>();
	 		   competenceRepository.findByDescription(description).forEach(listeCompetence::add);
	 		   Iterator<Competence> it= listeCompetence.iterator();
	 		   Competence competence=it.next();
	           return competence; 		  
	    	}
	    	
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		return null;
	    	}
	    }*/
		
		@GetMapping(value = "competence/{description}")
		public Competence findByCompetence(@PathVariable String description) {
			try {
			System.out.println("recherche Competence de la description "+description);

	 
			Competence customers = (Competence) competenceRepository.findByDescription(description);
			return customers;
			
			}
	    	catch(Exception e)
	    	{
	    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	    		e.printStackTrace();
	    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");

	    		return null;
	    	}
		}
		
		public Competence findByCompetenceLocale( String description) {
			try {
			System.out.println("recherche Customer de l'age"+description);

	 
			Competence customers = (Competence) competenceRepository.findByDescription(description);
			return customers;
			}
	    	catch(Exception e)
	    	{
	    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	    		e.printStackTrace();
	    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");

	    		return null;
	    	}
		}
		
		//recherher nom
		@GetMapping("/competence/description/{description}")
		 public Competence getComptenceByDescription(@PathVariable("description") String description)
		 {
		    try
		    {
		       System.out.println("Get Comptence.description...");
		 	   List<Competence> listeCompetence = new ArrayList<>();
		 	   competenceRepository.findByDescription(description).forEach(listeCompetence::add);
		 	   Iterator<Competence> it= listeCompetence.iterator();

		 	   Competence competence=it.next();
		       Competence maCompetence=new Competence();
		       maCompetence.setIdcompetence(competence.getIdcompetence());
		       maCompetence.setDescription(competence.getDescription());
		 	   return maCompetence; 		  

		    }
		    	
		    catch(Exception e)
		    {
		       System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		    	e.printStackTrace();
		    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		    	return null;
		    }
		}
		@DeleteMapping("/competence/{id}")
		public ResponseEntity<String> deleteComptence(@PathVariable("id") int id) {
			try
			{
			   System.out.println("Delete Competence with ID = " + id + "...");
			   competenceRepository.deleteById(id);
			   return new ResponseEntity<>("1", HttpStatus.OK);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return new ResponseEntity<>("0",HttpStatus.EXPECTATION_FAILED);
			}
		}
	 
		@DeleteMapping("/comptence/delete")
		public ResponseEntity<String> deleteAllComptence() {
			try
			{
			    System.out.println("Delete All Competence...");
			    competenceRepository.deleteAll();
			    return ResponseEntity.status(HttpStatus.OK).body("1");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("0");
			}
		}
		@PutMapping("/competence/{id}")
		public ResponseEntity<Competence> updateCustomer(@PathVariable("id") int id, @RequestBody Competence competence) {
			try
			{
			    System.out.println("Update Competence with ID = " + id + "...");
			    Optional<Competence> competenceData = competenceRepository.findById(id);
			    if (competenceData.isPresent()) {
				     Competence _competence = competenceData.get();
				     _competence.setIdcompetence(competence.getIdcompetence());
				     _competence.setDescription(competence.getDescription());
				     _competence.setEmployees(competence.getEmployees());
				     _competence.setDemandes(competence.getDemandes());
				     return ResponseEntity.status(HttpStatus.OK).body(competenceRepository.save(_competence));
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
		
		//recherhe  Employer
				@GetMapping("/competence/employe/description/{description}")
				 public List<Employee> getComptenceByEmploeyee(@PathVariable("description") String description)
				 {
				    try
				    {
				       System.out.println("Get Comptence.description...");
				 	   List<Competence> listeCompetence = new ArrayList<>();
				 	   competenceRepository.findByDescription(description).forEach(listeCompetence::add);
				 	   Iterator<Competence> it= listeCompetence.iterator();
				 	   HashSet<Employee> setEmployer= new HashSet <Employee>();
				 	   while(it.hasNext())
				 	   {
				 		   Competence competence= it.next();
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
