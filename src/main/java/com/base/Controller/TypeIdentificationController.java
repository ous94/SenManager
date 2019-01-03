package com.base.Controller;

import java.util.ArrayList;
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
	@PostMapping(value = "/typeIdentification/create")
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
	}
	@DeleteMapping("/typeIdentification/{id}")
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
<<<<<<< HEAD
			 TypeIdentification typeIdentification=it.next();
			 TypeIdentification monTypeIdentification=new TypeIdentification();
			 monTypeIdentification.setIdidentification(typeIdentification.getIdidentification());
			 monTypeIdentification.setNom(typeIdentification.getNom());
			 return monTypeIdentification ;
=======
			 TypeIdentification typeIdentification= new TypeIdentification();
			 TypeIdentification montypeIdentification=  it.next();
			 typeIdentification.setIdidentification(montypeIdentification.getIdidentification());
			 typeIdentification.setNom(montypeIdentification.getNom());
			   return typeIdentification;
			 
>>>>>>> 3fb07ccdeb040aa1f3caff8fff1580a3162d95a7
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	 @GetMapping("/identification/nom")
 	public List<String> getAllIdentificationnom() {
 		try
 		{
 		   System.out.println("Get all Localite.nom...");
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
	
	


}
