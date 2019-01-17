package com.base.Controller;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.base.Entities.Employee;
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
	@PostMapping(value = "/localites/create")
	public Localite postCustomer(@RequestBody Localite localite) {
		try
		{
		    Localite newLocalite=new Localite();
		    Localite localitert = localiteRepository.save(newLocalite);
		    return localitert;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@DeleteMapping("/localites/{id}")
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


}
