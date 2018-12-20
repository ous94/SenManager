package com.base.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Repository.DisponibiliteRepository;
import com.base.Entities.Disponibilite;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class DisponibiliteController {
	
	@Autowired
	DisponibiliteRepository disponibiliteRepository;
	
	@GetMapping("/disponibilite/observation")
	public List<String> getAllnomLangue() {
		try
		{
		   System.out.println("...");
		   List<Disponibilite> listeDisponibilite = new ArrayList<>();
		   disponibiliteRepository.findAll().forEach(listeDisponibilite::add);
		   List<String> observationDisponibilite = new ArrayList<>();
		   Iterator<Disponibilite> it= listeDisponibilite.iterator();
		   while(it.hasNext())
		   {
			   observationDisponibilite.add(it.next().getObservation());
			   
			   
		   }
		   return observationDisponibilite;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
