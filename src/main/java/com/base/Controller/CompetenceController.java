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

import com.base.Repository.ComptenceRepository;
import com.base.Entities.Competence;
import com.base.Entities.Disponibilite;
import com.base.Entities.Employee;
import com.base.Entities.Ethnies;
import com.base.Entities.Langue;
import com.base.Entities.Niveauetude;
import com.base.Entities.Pays;
import com.base.Entities.RechercheCompetence;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class CompetenceController {

	@Autowired
	ComptenceRepository competenceRepository;
	
	@PostMapping(value = "/competence/create")
	public Competence createCompetence(@RequestBody Competence competence) {
		try
		{
			   System.out.println("creation  competence...");
			   if(findByCompetenceLocale(competence.getDescription()))
			   {
				   return null;
			   }
			   else {
			   Competence competence2 = new Competence();
			   
			   competence2.setDescription(competence.getDescription());
			   competenceRepository.save(competence2);
			   }
			   
		}catch (Exception e) {
			e.printStackTrace();
		}
		return competence;
	}
	//Get All Competence avec plus de Details
	@GetMapping("/competences")
	public List<Competence> getAllCompetence() {
		try
		{
		   System.out.println("...");
		   List<Competence> listeCompetence = new ArrayList<>();
		   competenceRepository.findAll().forEach(listeCompetence::add);
		   for(int  i=0;i< listeCompetence.size();i++)
		   {
			  // Employee employee = new Employee();
			   
			   listeCompetence.get(i).setEmployees(null);
			   listeCompetence.get(i).setDemandes(null);
		   }
		   return listeCompetence;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	//
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
		

		
		public Boolean findByCompetenceLocale( String description) {
			try {
			System.out.println("recherche Customer de l'age"+description);

	 
			List<Competence> customers =  competenceRepository.findByDescription(description);
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
		
		//recherher nom
		@GetMapping("/competence/description/{description}")
		 public Competence getComptenceByDescription(@PathVariable("description") String description)
		 {
		    try
		    {
		       System.out.println("Get Comptence.description...");
		 	   List<Competence> listeCompetence = new ArrayList<>();
		 	   competenceRepository.findByDescription(description).forEach(listeCompetence::add);
		 	   if(listeCompetence.size()==0)
		 	   {
		 		   return null;
		 	   }
		 	  Iterator<Competence> it= listeCompetence.iterator();

		 	   Competence competence=it.next();
		       Competence maCompetence=new Competence();
		       maCompetence.setIdcompetence(competence.getIdcompetence());
		       maCompetence.setDescription(competence.getDescription());
		 	   return maCompetence; 		  

		 	  
		    }
		    	
		    catch(Exception e)
		    {
		       System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		    	e.printStackTrace();
		    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		    	return null;
		    }
		}
		@DeleteMapping("/competence/{id}")
		public ResponseEntity<String> deleteComptence(@PathVariable("id") int id) {
			try
			{
			   System.out.println("Delete Competence with ID = " + id + "...");
			   competenceRepository.deleteById(id);
			   return new ResponseEntity<>("1", HttpStatus.OK);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return new ResponseEntity<>("0",HttpStatus.EXPECTATION_FAILED);
			}
		}
	 
		@DeleteMapping("/comptence/delete")
		public ResponseEntity<String> deleteAllComptence() {
			try
			{
			    System.out.println("Delete All Competence...");
			    competenceRepository.deleteAll();
			    return ResponseEntity.status(HttpStatus.OK).body("1");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("0");
			}
		}
		@PutMapping("/competence/{id}")
		public ResponseEntity<Competence> updateCustomer(@PathVariable("id") int id, @RequestBody Competence competence) {
			try
			{
			    System.out.println("Update Competence with ID = " + id + "...");
			    Optional<Competence> competenceData = competenceRepository.findById(id);
			    if (competenceData.isPresent()) {
				     Competence _competence = competenceData.get();
				     _competence.setIdcompetence(competence.getIdcompetence());
				     _competence.setDescription(competence.getDescription());
				     _competence.setEmployees(competence.getEmployees());
				     _competence.setDemandes(competence.getDemandes());
				     return ResponseEntity.status(HttpStatus.OK).body(competenceRepository.save(_competence));
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
		
		//recherhe  Employer
				@GetMapping("/competence/employe/description/{description}")
				 public List<Employee> getComptenceByEmployee(@PathVariable("description") String description)
				 {
				    try
				    {
				       System.out.println("Get Comptence.description...");
				 	   List<Competence> listeCompetence = new ArrayList<>();
				 	   competenceRepository.findByDescription(description).forEach(listeCompetence::add);
				 	   Iterator<Competence> it= listeCompetence.iterator();
				 	   HashSet<Employee> setEmployer= new HashSet <Employee>();
				 	   while(it.hasNext())
				 	   {
				 		   Competence competence= it.next();
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
				
	@PostMapping("/competence/description/employes")
	public HashSet<Employee> getAllEmployesFromListeCompetence(@RequestBody List<Competence> listeCompetence)
	{
		try
		{
			HashSet<Employee> listeEmploye1=new HashSet<Employee>();
			HashSet<Employee> listeEmploye2 =new HashSet<Employee>();
			HashSet<Competence> listeCompetence1=new HashSet<Competence>();
			Iterator<Competence> itCompetence=listeCompetence.iterator();
			while(itCompetence.hasNext())
			{
				competenceRepository.findByDescription(((Competence)(itCompetence.next())).getDescription()).forEach(listeCompetence1::add);
			}
			Iterator<Competence> itCompetence1=listeCompetence1.iterator();
			while(itCompetence1.hasNext())
			{
				listeEmploye1.addAll(((Competence)(itCompetence1.next())).getEmployees());
			}
			Iterator<Employee> itEmploye1=listeEmploye1.iterator();
			while(itEmploye1.hasNext())
			{
				   Employee employee=new Employee();
				   Employee emp=(Employee)itEmploye1.next();
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
				   Iterator<Competence> itCompetences=emp.getCompetences().iterator();
				   Iterator<Disponibilite> itDisponibilite=emp.getDisponibilites().iterator();
				   Iterator<Langue> itLangue=emp.getLangues().iterator();
				   HashSet<Competence>setCompetence=new HashSet<Competence>();
				   HashSet<Langue> setLangue=new HashSet<Langue>();
				   HashSet<Disponibilite> setDisponibilite=new HashSet<Disponibilite>();
				   Ethnies ethnie=emp.getEthny();
				   Niveauetude niveauEtude=emp.getNiveauetude();
				   Pays pays=emp.getPay();
				   while(itCompetences.hasNext())
				   {
					   Competence comp=itCompetences.next();
					   comp.setDemandes(null);
					   comp.setEmployees(null);
					   setCompetence.add(comp);
				   }
				   while(itDisponibilite.hasNext())
				   {
					   Disponibilite dispo=itDisponibilite.next();
					   dispo.setEmployee(null);
					   setDisponibilite.add(dispo);
				   }
				   while(itLangue.hasNext())
				   {
					  Langue lang=itLangue.next();
					  lang.setEmployees(null);
					  setLangue.add(lang);
				   }
				   Ethnies ethnies=new Ethnies();
				   Niveauetude niveau=new Niveauetude();
				   Pays pys=new Pays();
				   ethnies.setIdethnies(ethnie.getIdethnies());
				   ethnies.setNom(ethnie.getNom());
				   niveau.setIdniveau(niveauEtude.getIdniveau());
				   niveau.setNiveau(niveauEtude.getNiveau());
				   pys.setIdpays(pays.getIdpays());
				   pys.setNom(pays.getNom());
				   employee.setCompetences(setCompetence);
				   employee.setDisponibilites(setDisponibilite);
				   employee.setLangues(setLangue);
				   employee.setPay(pys);
				   employee.setEthny(ethnies);
				   employee.setNiveauetude(niveau);
				   listeEmploye2.add(employee);
			}
			return listeEmploye2;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("deprecation")
	@PostMapping("/competence/description/employes/pagination")
	public HashSet<Employee> getAllEmployesFromListeCompetencePagination(@RequestBody RechercheCompetence rechercheCompetence)
	{
		try
		{
			HashSet<Employee> listeEmploye1=new HashSet<Employee>();
			HashSet<Employee> listeEmploye2 =new HashSet<Employee>();
			List<String>listeDescription=new ArrayList<String>();
			System.out.println(rechercheCompetence.toString());
			Iterator<Competence> itDescription=rechercheCompetence.getListeCompetences().iterator();
			while(itDescription.hasNext())
			{
				Competence c=itDescription.next();
				listeDescription.add(c.getDescription());
			}
			competenceRepository.rechercheEmployeeCompetenceDescription(listeDescription, new PageRequest(rechercheCompetence.getOffset(),2)).forEach(listeEmploye1::add);
			System.out.println("########"+listeEmploye1.size());
			Iterator<Employee> itEmploye1=listeEmploye1.iterator();
			while(itEmploye1.hasNext())
			{
				   Employee employee=new Employee();
				   Employee emp=(Employee)itEmploye1.next();
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
				   Iterator<Competence> itCompetences=emp.getCompetences().iterator();
				   Iterator<Disponibilite> itDisponibilite=emp.getDisponibilites().iterator();
				   Iterator<Langue> itLangue=emp.getLangues().iterator();
				   HashSet<Competence>setCompetence=new HashSet<Competence>();
				   HashSet<Langue> setLangue=new HashSet<Langue>();
				   HashSet<Disponibilite> setDisponibilite=new HashSet<Disponibilite>();
				   Ethnies ethnie=emp.getEthny();
				   Niveauetude niveauEtude=emp.getNiveauetude();
				   Pays pays=emp.getPay();
				   while(itCompetences.hasNext())
				   {
					   Competence comp=itCompetences.next();
					   comp.setDemandes(null);
					   comp.setEmployees(null);
					   setCompetence.add(comp);
				   }
				   while(itDisponibilite.hasNext())
				   {
					   Disponibilite dispo=itDisponibilite.next();
					   dispo.setEmployee(null);
					   setDisponibilite.add(dispo);
				   }
				   while(itLangue.hasNext())
				   {
					  Langue lang=itLangue.next();
					  lang.setEmployees(null);
					  setLangue.add(lang);
				   }
				   Ethnies ethnies=new Ethnies();
				   Niveauetude niveau=new Niveauetude();
				   Pays pys=new Pays();
				   ethnies.setIdethnies(ethnie.getIdethnies());
				   ethnies.setNom(ethnie.getNom());
				   niveau.setIdniveau(niveauEtude.getIdniveau());
				   niveau.setNiveau(niveauEtude.getNiveau());
				   pys.setIdpays(pays.getIdpays());
				   pys.setNom(pays.getNom());
				   employee.setCompetences(setCompetence);
				   employee.setDisponibilites(setDisponibilite);
				   employee.setLangues(setLangue);
				   employee.setPay(pys);
				   employee.setEthny(ethnies);
				   employee.setNiveauetude(niveau);
				   listeEmploye2.add(employee);
			}
			return listeEmploye2;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
