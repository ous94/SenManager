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

import com.base.Entities.Competence;
import com.base.Repository.ComptenceRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class CompetenceController {

	@Autowired
	ComptenceRepository competenceRepository;
	/*
	@GetMapping("/competence/description/{tabdescription}")
	public List<Competence> getBydescriptionCompetence(@PathVariable("tabdescription")String[] tabdescription) {
		try
		{
		   System.out.println("++++++");
		   List<Competence> listeCompetence = new ArrayList<>();
		  for(int i=0;i<tabdescription.length;i++)
		  {
			  competenceRepository.findByDescription(tabdescription[i]).forEach(listeCompetence::add);
			  
		  }
		  return listeCompetence;
		   
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	*/
	@GetMapping("/competence/description")
	public String[] getAlldescriptionCompetence() {
		try
		{
		   System.out.println("...");
		   List<Competence> listeCompetence = new ArrayList<>();
		   competenceRepository.findAll().forEach(listeCompetence::add);
		   String[] nomCompetence=new String[listeCompetence.size()];
		   for(int  i=0;i< listeCompetence.size();i++)
		   {
			   nomCompetence[i]=listeCompetence.get(i).getDescription();
		   }
		   return nomCompetence;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	//recherher nom
	//	@GetMapping("/competence/{description}")
	
	    /*    public Competence getComptenceByDescription(String description)
<<<<<<< HEAD
=======

>>>>>>> 773baa67c38de05648af4a710c61aea847a59470
		@GetMapping("/competence/description/{description}")
	        public Competence getComptenceByDescription(@PathVariable("description") String description)
	    {
	    	try
	    	{
	    	   System.out.println("Get Comptence.description...");
	 		   List<Competence> listeCompetence = new ArrayList<>();
	 		   competenceRepository.findByDescription(description).forEach(listeCompetence::add);
	 		   Iterator<Competence> it= listeCompetence.iterator();
	 		   Competence competence=it.next();
	           return competence; 		  
	    	}
	    	
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		return null;
	    	}
	    }*/
		
		@GetMapping(value = "competence/{description}")
		public Competence findByCompetence(@PathVariable String description) {
			try {
			System.out.println("recherche Customer de l'age"+description);

	 
			Competence customers = (Competence) competenceRepository.findByDescription(description);
			return customers;
			}
	    	catch(Exception e)
	    	{
	    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	    		e.printStackTrace();
	    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");

	    		return null;
	    	}
		}
		
		public Competence findByCompetenceLocale( String description) {
			try {
			System.out.println("recherche Customer de l'age"+description);

	 
			Competence customers = (Competence) competenceRepository.findByDescription(description);
			return customers;
			}
	    	catch(Exception e)
	    	{
	    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	    		e.printStackTrace();
	    		System.out.println("Hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");

	    		return null;
	    	}
		}
		
		//recherher nom
		@GetMapping("/competence/description/{description}")
		 public Competence getComptenceByDescription(@PathVariable("description") String description)
		 {
		    try
		    {
		       System.out.println("Get Comptence.description...");
		 	   List<Competence> listeCompetence = new ArrayList<>();
		 	   competenceRepository.findByDescription(description).forEach(listeCompetence::add);
		 	   Iterator<Competence> it= listeCompetence.iterator();
		 	   Competence competence=it.next();
		          return competence; 		  
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
