package com.base.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.Entities.Competence;
import com.base.Repository.ComptenceRepository;

public class TCompetenceController {
	
	@Autowired
	ComptenceRepository competenceRepository;
	public Competence getBydescriptionCompetence(String description) {
		try
		{
		   System.out.println("...");
		   Competence comp=null;
		   List<Competence> listeCompetence = new ArrayList<>();
		   competenceRepository.findAll().forEach(listeCompetence::add);
		   Iterator<Competence> itcomp=listeCompetence.iterator();
		   while(itcomp.hasNext())
		   {
			   comp=itcomp.next();
			   if(comp.getDescription().compareToIgnoreCase(description)==0)
			   {
				   break;
			   }
				   
		   }
		   return comp;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

}
