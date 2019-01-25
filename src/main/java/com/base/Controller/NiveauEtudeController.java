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

import com.base.Repository.NiveauEtudeRepository;
import com.base.Entities.Competence;
import com.base.Entities.Employee;
import com.base.Entities.Ethnies;
import com.base.Entities.Niveauetude;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class NiveauEtudeController {
	
	@Autowired
	NiveauEtudeRepository niveauEtudeRepository;
	
	
	@PostMapping(value = "/niveauEtudes/create")
	public Niveauetude createEthnie(@RequestBody Niveauetude niveauEtude ) {
		try
		{
			   System.out.println("creation  niveauEtude...");
			   if(findByniveauEtudeLocale(niveauEtude.getNiveau()))
			   {
				   return null;
			   }
			   else {
				   Niveauetude  niveauEtude2 = new Niveauetude();
			   
				   niveauEtude2.setNiveau(niveauEtude.getNiveau());
			   niveauEtudeRepository.save(niveauEtude2);
			   }
			   
		}catch (Exception e) {
			e.printStackTrace();
		}
		return niveauEtude;
	}
	
	//fonction locale
	public Boolean findByniveauEtudeLocale( String nom) {
		try {
		System.out.println("recherche compentence "+nom);

 
		List<Niveauetude> customers =  niveauEtudeRepository.findByNiveau(nom);
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
	
	@PutMapping("/niveauEtudes/edite/{id}")
	public ResponseEntity<Niveauetude> updateCustomer(@PathVariable("id") int id, @RequestBody Niveauetude niveauetude) {
		try
		{
		    System.out.println("Update ethnies with ID = " + id + "...");
		    Optional<Niveauetude> niveauetudeData = niveauEtudeRepository.findById(id);
			    List<Niveauetude> cop = niveauEtudeRepository.findByNiveau(niveauetude.getNiveau());
			    if(cop.size()>0)
			    {
			    	return null;
			    }
			    else if (niveauetudeData.isPresent()) {
			    	Niveauetude _competence = niveauetudeData.get();
			     _competence.setIdniveau(id);
			     _competence.setNiveau(niveauetude.getNiveau());;
			     _competence.setEmployees(null);
			     return ResponseEntity.status(HttpStatus.OK).body(niveauEtudeRepository.save(_competence));
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
	@GetMapping("/niveauEtudes/pagination/{offset}")
	public List<Niveauetude> getAllCompPagination(@PathVariable("offset")int offset) {
		try
		{
		   System.out.println("...");
		   List<Niveauetude> listeCompetence = new ArrayList<>();
		   niveauEtudeRepository.mesNiveau(new PageRequest(offset,5)).forEach(listeCompetence::add);
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

	
	
	
	@GetMapping("/niveauEtude")
	public List<Niveauetude> getAllNiveauEtude() {
		try
		{
		   System.out.println("Get all NiveauEtude...");
		   List<Niveauetude> listeNiveauEtude = new ArrayList<>();
		   niveauEtudeRepository.findAll().forEach(listeNiveauEtude::add);
		   return listeNiveauEtude;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@PostMapping(value = "/niveauEtude/new /create")
	public Niveauetude creatClient(@RequestBody Niveauetude niveauEtude) {
		try
		{
		    Niveauetude newNiveauEtude=new Niveauetude();
		    Niveauetude niveauEtudert = niveauEtudeRepository.save(newNiveauEtude);
		    return niveauEtudert;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@DeleteMapping("/niveauEtude/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") int id) {
		try
		{
		   System.out.println("Delete NiveauEtude with ID = " + id + "...");
		   niveauEtudeRepository.deleteById(id);
		   return new ResponseEntity<>("NiveauEtude has been deleted!", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("", HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/niveauetude/niveau")
	public List<String> getAllnomEthnies() {
		try
		{
		   System.out.println("Get all Ethnies...");
		   List<Niveauetude> listeEthnies = new ArrayList<>();
		   niveauEtudeRepository.findAll().forEach(listeEthnies::add);
		   List<String> nomethnies = new ArrayList<>();
		   Iterator<Niveauetude> it= listeEthnies.iterator();
		   while(it.hasNext())
		   {
			   nomethnies.add(it.next().getNiveau());
			   
			   
		   }
		   return nomethnies;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/niveauEtudes/niveau/{niveau}")
	public List<String> getAllnomNiveauEtude(@PathVariable("niveau") String niveau) {
		try
		{
		   System.out.println("Get all NiveauEtude.nom...");
		   List<Niveauetude> listeNiveauEtude = new ArrayList<>();
		   niveauEtudeRepository.findByNiveau(niveau).forEach(listeNiveauEtude::add);
		   List<String> nomNiveauEtude = new ArrayList<>();
		   Iterator<Niveauetude> it= listeNiveauEtude.iterator();
		   while(it.hasNext())
		   {
			   nomNiveauEtude.add(it.next().getNiveau());
			   
			   
		   }
		   return nomNiveauEtude;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@GetMapping("/nniveauEtudes/niveau/{niveau}")
	public Niveauetude getNiveauEtudeByNiveau(@PathVariable("niveau")String niveau)
	{
		try
		{
			List<Niveauetude> listeNiveauEtude = new ArrayList<>();
			niveauEtudeRepository.findByNiveau(niveau).forEach(listeNiveauEtude::add);
			Iterator<Niveauetude> it= listeNiveauEtude.iterator();
			
			Niveauetude niveauEtude=it.next();

			Niveauetude monNiveau=new Niveauetude();
			monNiveau.setIdniveau(niveauEtude.getIdniveau());
			monNiveau.setNiveau(niveauEtude.getNiveau());
			return monNiveau;
			
			
		}
		catch(Exception e)
		{
			return null;
		}
	}
	//recherhe  Employer par niveau Etude
	@GetMapping("/employes/niveau/{description}")
	 public List<Employee> getComptenceByEmploeyee(@PathVariable("description") String description)
	 {
	    try
	    {
	       System.out.println("Get Comptence.description...");
	 	   List<Niveauetude> listeCompetence = new ArrayList<>();
	 	   niveauEtudeRepository.findByNiveau(description).forEach(listeCompetence::add);
	 	   Iterator<Niveauetude> it= listeCompetence.iterator();
	 	   HashSet<Employee> setEmployer= new HashSet <Employee>();
	 	   while(it.hasNext())
	 	   {
	 		   Niveauetude competence= it.next();
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
