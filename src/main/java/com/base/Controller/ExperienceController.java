package com.base.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Repository.ExperienceRepository;
import com.base.Entities.Experience;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class ExperienceController {
	
	@Autowired
	ExperienceRepository experienceRepository;
	
	@GetMapping("/experience/commentaire")
	public List<String> getAllCommentaireExperience() {
		try
		{
		   System.out.println("Get all Experience.Commentaire...");
		   List<Experience> listeExperience = new ArrayList<>();
		   experienceRepository.findAll().forEach(listeExperience::add);
		   List<String> commentaireExperience = new ArrayList<>();
		   Iterator<Experience> it= listeExperience.iterator();
		   while(it.hasNext())
		   {
			   commentaireExperience.add(it.next().getCommentaire());
			   
			   
		   }
		   return commentaireExperience;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
