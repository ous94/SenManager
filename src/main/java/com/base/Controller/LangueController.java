package com.base.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping("/langue/nom")
	public String[] getAllnomLangue() {
		try
		{
		   System.out.println("Get all Ethnies...");
		   List<Langue> listeLangue = new ArrayList<>();
		   langueRepository.findAll().forEach(listeLangue::add);
/*         List<String> nomlangue = new ArrayList<>();
		   Iterator<Langue> it= listeLangue.iterator();
		   while(it.hasNext())
		   {
			   nomlangue.add(it.next().getNom());
			   
			   
		   }
		   return nomlangue; */		   	   
		   //nouvelle demande ,retourne maintenant  un tableau  
           String [] nomlangue= new String[listeLangue.size()];
           for(int i=0;i<listeLangue.size();i++)
           {
	          nomlangue[i]=listeLangue.get(i).getNom();
           }
          return nomlangue;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
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

}
