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

import com.base.Repository.EthniesRepository;
import com.base.Entities.Employee;
import com.base.Entities.Ethnies;
import com.base.Entities.Pays;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class EthniesController {
	
	@Autowired
	EthniesRepository ethniesRepository;
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
			return null;
		}
	}
	@PostMapping(value = "/ethnies/create")
	public Ethnies creatClient(@RequestBody Ethnies ethnies) {
		try
		{
		    Ethnies newEthnies=new Ethnies();
		    Ethnies ethniesrt = ethniesRepository.save(newEthnies);
		    return ethniesrt;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@DeleteMapping("/ethnies/{id}")
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
