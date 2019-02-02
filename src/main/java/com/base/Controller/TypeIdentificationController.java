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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Entities.Ethnies;
import com.base.Entities.Localite;
import com.base.Entities.TypeIdentification;
import com.base.Repository.TypeIdentificationRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class TypeIdentificationController {
	
	@Autowired
	TypeIdentificationRepository typeIdentificationRepository;
	@GetMapping("/typeIdentification")
	public List<TypeIdentification> getAllTypeIdentification() {
		try
		{
		   System.out.println("Get all TypeIdentification...");
		   List<TypeIdentification> listeTypeIdentification = new ArrayList<>();
		   typeIdentificationRepository.findAll().forEach(listeTypeIdentification::add);
		   return listeTypeIdentification;
		}
		catch(Exception e)
		{
			return null;
		}
	}
/*	@PostMapping(value = "/typeIdentification/new/create")
	public TypeIdentification creatTypeIdentification(@RequestBody TypeIdentification typeIdentification) {
		try
		{
		    TypeIdentification newTypeIdentification=new TypeIdentification();
		    TypeIdentification typeIdentificationrt = typeIdentificationRepository.save(newTypeIdentification);
		    return typeIdentificationrt;
		}
		catch(Exception e)
		{
			return null;
		}
	}*/
	@DeleteMapping("/typeIdentification/delete/{id}")
	public ResponseEntity<String> deleteTypeIdentification(@PathVariable("id") int id) {
		try
		{
		   System.out.println("Delete TypeIdentification with ID = " + id + "...");
		   typeIdentificationRepository.deleteById(id);
		   return new ResponseEntity<>("TypeIdentification has been deleted!", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("", HttpStatus.EXPECTATION_FAILED);
		}
	}
	// recherche
	@GetMapping("/typeIdentification/nom/{nom}")
	public List<String> getAllnomTypeIdentification(@PathVariable("nom") String nom) {
		try
		{
		   System.out.println("Get all TypeIdentification.nom...");
		   List<TypeIdentification> listeTypeIdentification = new ArrayList<>();
		   typeIdentificationRepository.findByNom(nom).forEach(listeTypeIdentification::add);
		   List<String> nomtypeIdentification = new ArrayList<>();
		   Iterator<TypeIdentification> it= listeTypeIdentification.iterator();
		   while(it.hasNext())
		   {
			   nomtypeIdentification.add(it.next().getNom());
			   
			   
		   }
		   return nomtypeIdentification;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@GetMapping("/ttypeIdentification/nom/{nom}")
	public TypeIdentification getTypeIdentificationByNom(@PathVariable("nom")String nom)
	{
		try
		{
			 List<TypeIdentification> listeTypeIdentification = new ArrayList<>();
			 typeIdentificationRepository.findByNom(nom).forEach(listeTypeIdentification::add);
			 Iterator<TypeIdentification> it= listeTypeIdentification.iterator();
			 if(it.hasNext())
			 {
				 TypeIdentification typeIdentification=it.next();
				 TypeIdentification monTypeIdentification=new TypeIdentification();
				 monTypeIdentification.setIdidentification(typeIdentification.getIdidentification());
				 monTypeIdentification.setNom(typeIdentification.getNom());
				 System.out.println("TypeIdentificaton.nom");
				 return monTypeIdentification ;
			 }
			 else
			 {
				 System.out.println("liste vite");
				 return null;
			 }
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	 @GetMapping("/identification/nom")
 	public List<String> getAllIdentificationnom() {
 		try
 		{
 		   System.out.println("Get all type...");
 		   List<TypeIdentification> listeidentification = new ArrayList<>();
 		   typeIdentificationRepository.findAll().forEach(listeidentification::add);
 		   List<String> monidentification = new ArrayList<>();
 		   Iterator<TypeIdentification> it= listeidentification.iterator();
 		   while(it.hasNext())
 		   {
 			  monidentification.add(it.next().getNom());
 			   
 			   
 		   }
 		   return monidentification;
 		}
 		catch(Exception e)
 		{
 			return null;
 		}
 	}
	
	//creation TypesIdentification
	  	@PostMapping("/typeIdentification/create")
		public TypeIdentification createEthnie(@RequestBody TypeIdentification ethnies) {
			try
			{
				   System.out.println("creation  localite...");
				   if(findByEthniesLocale(ethnies.getNom()))
				   {
					   return null;
				   }
				   else {
					   TypeIdentification  ethnies2 = new TypeIdentification();
				   
					   ethnies2.setNom(ethnies.getNom());
				   typeIdentificationRepository.save(ethnies2);
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

	 
			List<TypeIdentification> customers =  typeIdentificationRepository.findByNom(nom);
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
		
		@PutMapping("/typeIdentification/edite/{id}")
		public ResponseEntity<TypeIdentification> updateCustomer(@PathVariable("id") int id, @RequestBody TypeIdentification localite) {
			try
			{
			    System.out.println("Update ethnies with ID = " + id + "...");
			    Optional<TypeIdentification> competenceData = typeIdentificationRepository.findById(id);
				    List<TypeIdentification> cop = typeIdentificationRepository.findByNom(localite.getNom());
				    if(cop.size()>0)
				    {
				    	return null;
				    }
				    else if (competenceData.isPresent()) {
				     TypeIdentification _competence = competenceData.get();
				     _competence.setIdidentification(id);
				     _competence.setNom(localite.getNom());;
				     _competence.setClients(null);
				     _competence.setEmployees(null);
				     return ResponseEntity.status(HttpStatus.OK).body(typeIdentificationRepository.save(_competence));
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
		@GetMapping("/typeIdentification/pagination/{offset}")
		public List<TypeIdentification> getAllCompPagination(@PathVariable("offset")int offset) {
			try
			{
			   System.out.println("...");
			   List<TypeIdentification> listeCompetence = new ArrayList<>();
			   typeIdentificationRepository.mestypes(new PageRequest(offset,5)).forEach(listeCompetence::add);
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
				e.printStackTrace();
				return null;
			}
		}
		
		//conter
		@GetMapping("/typidentification/nombre")				
		public int conter()
		{
		try {
				int nombre = (int) typeIdentificationRepository.count();
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
