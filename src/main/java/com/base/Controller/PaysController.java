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

import com.base.Entities.Competence;
import com.base.Entities.Pays;
import com.base.Entities.TypeIdentification;
import com.base.Repository.PaysRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class PaysController {
	
	@Autowired 
	PaysRepository paysRepository;
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
	@PostMapping(value = "/pays/create")
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
	@DeleteMapping("/pays/{id}")
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
 }
