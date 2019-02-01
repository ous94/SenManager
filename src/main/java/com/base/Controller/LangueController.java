package com.base.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Entities.Langue;
import com.base.Repository.LangueRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class LangueController {
	
	@Autowired
	LangueRepository langueRepository;
	
	// recherche par nom langue
	@GetMapping("/langues/nom/{nom}")
	public List<String> getAllnomLanguebynom(@PathVariable("nom") String nom) {
		try
		{
		   System.out.println("Get all Langue.nom...");
		   List<Langue> listeLangue = new ArrayList<>();
		   langueRepository.findByNom(nom).forEach(listeLangue::add);
		   List<String> nomlangue = new ArrayList<>();
		   
		   
		   Iterator<Langue> it= listeLangue.iterator();
		   while(it.hasNext())
		   {
			   nomlangue.add(it.next().getNom()); 
		   }
		   return nomlangue;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@GetMapping("/langues")
	public List<String> getAllnomLangues() {
		try
		{
		   System.out.println("Get all Langues...");
		   List<Langue> listeLangue = new ArrayList<>();
		   langueRepository.findAll().forEach(listeLangue::add);
		   List<String> nomLangue = new ArrayList<>();
		   Iterator<Langue> it= listeLangue.iterator();
		   while(it.hasNext())
		   {
			   nomLangue.add(it.next().getNom());
		   }
		   return nomLangue;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	//bon////////////////:
	
	@GetMapping("/langue/nom/{nom}")
	public Langue getLangueByNom(@PathVariable("nom")String nom) {
		try
		{
		   System.out.println("Get  Langue.nom...");
		   List<Langue> listeLangue = new ArrayList<>();
		   langueRepository.findByNom(nom).forEach(listeLangue::add);
		   Iterator<Langue> itlangue=listeLangue.iterator();

		   Langue langue=itlangue.next();
		   Langue maLangue=new Langue();
		   maLangue.setIdlangue(langue.getIdlangue());
		   maLangue.setNom(langue.getNom());
		   return maLangue;

		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//creation Localite
  	@PostMapping(value = "/langue/create")
	public Langue createEthnie(@RequestBody Langue ethnies) {
		try
		{
			   System.out.println("creation  langue...");
			   if(findByEthniesLocale(ethnies.getNom()))
			   {
				   return null;
			   }
			   else {
				   Langue  ethnies2 = new Langue();
			   
				   ethnies2.setNom(ethnies.getNom());
			   langueRepository.save(ethnies2);
			   }
			   
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ethnies;
	}
	
	//fonction locale
	public Boolean findByEthniesLocale( String nom) {
		try {
		System.out.println("recherche langue "+nom);

 
		List<Langue> customers =  langueRepository.findByNom(nom);
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
	
	@PutMapping("/langue/edite/{id}")
	public ResponseEntity<Langue> updateCustomer(@PathVariable("id") int id, @RequestBody Langue localite) {
		try
		{
		    System.out.println("Update Langue with ID = " + id + "...");
		    Optional<Langue> competenceData = langueRepository.findById(id);
			    List<Langue> cop = langueRepository.findByNom(localite.getNom());
			    if(cop.size()>0)
			    {
			    	return null;
			    }
			    else if (competenceData.isPresent()) {
			     Langue _competence = competenceData.get();
			     _competence.setIdlangue(id);
			     _competence.setNom(localite.getNom());;
			     _competence.setEmployees(null);
			     return ResponseEntity.status(HttpStatus.OK).body(langueRepository.save(_competence));
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
	@GetMapping("/langue/pagination/{offset}")
	public List<Langue> getAllCompPagination(@PathVariable("offset")int offset) {
		try
		{
		   System.out.println("...");
		   List<Langue> listeCompetence = new ArrayList<>();
		   langueRepository.mesLangue(new PageRequest(offset,5)).forEach(listeCompetence::add);
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
			@GetMapping("/langue/nombre")				
			public int conter()
			{
			try {
					int nombre = (int) langueRepository.count();
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
