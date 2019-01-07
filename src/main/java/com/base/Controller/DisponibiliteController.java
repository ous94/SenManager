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
import com.base.Repository.DisponibiliteRepository;
import com.base.Entities.Disponibilite;
import com.base.Entities.Employee;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class DisponibiliteController {
	
	@Autowired
	DisponibiliteRepository disponibiliteRepository;
	
	@PostMapping(value = "/disponibilite/create")
	public Disponibilite creatPays(@RequestBody Disponibilite disponibilite) {
		try
		{
			//String idString=""+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)));
           // Integer id=java.lang.Integer.valueOf(idString);
		    Disponibilite newDisponibilite=new Disponibilite();
		    System.out.println("Debut Insertion Disponibilite");
		    Disponibilite  disponibilitert= disponibiliteRepository.save(disponibilite);
		    newDisponibilite.setIddisponibilite(disponibilitert.getIddisponibilite());
		    newDisponibilite.setObservation(disponibilitert.getObservation());
		    newDisponibilite.setHoraire(disponibilite.getHoraire());
		    newDisponibilite.setMoment(disponibilite.getMoment());
		    System.out.println("Fin insertion Disponibilite");
		    return newDisponibilite;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/disponibilite/horaire/{horaire}")
	public List<Employee> getDisponibiliteEmployeeByHoraire(@PathVariable("horaire") String horaire) {
		try
		{
		   System.out.println("Get Employee by Disponibilite.Horaire");
		   List<Disponibilite> listeDisponibilite = new ArrayList<>();
		   List<Employee> listeEmployes =new ArrayList<>();
		   disponibiliteRepository.findByHoraire(horaire).forEach(listeDisponibilite::add);
		   Iterator<Disponibilite> it= listeDisponibilite.iterator();
		   Disponibilite disponibilite=new Disponibilite();
		   Employee employee=new Employee();
		   while(it.hasNext())
		   {
			   disponibilite=it.next();
			   employee=disponibilite.getEmployee();
			   employee.setDisponibilites(null);
			   employee.setCompetences(null);
			   employee.setDemandes(null);
			   employee.setDocuments(null);
			   employee.setEthny(null);
			   employee.setExperiences(null);
			   employee.setFormations(null);
			   employee.setLangues(null);
			   employee.setLocalite(null);
			   employee.setNiveauetude(null);
			   employee.setPay(null);
			   employee.setTypeIdentification(null);
			   listeEmployes.add(employee);
			   
			   
		   }
		   return listeEmployes;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/disponibilite/moment/{momemt}")
	public List<Employee> getEmployeeDisponibiliteByMoment(@PathVariable("moment") String moment) {
		try
		{
		   System.out.println("Get Employee by Disponibilite.Moment");
		   List<Disponibilite> listeDisponibilite = new ArrayList<>();
		   List<Employee> listeEmployes =new ArrayList<>();
		   disponibiliteRepository.findByMoment(moment).forEach(listeDisponibilite::add);
		   Iterator<Disponibilite> it= listeDisponibilite.iterator();
		   Disponibilite disponibilite=new Disponibilite();
		   Employee employee=new Employee();
		   while(it.hasNext())
		   {
			   disponibilite=it.next();
			   employee=disponibilite.getEmployee();
			   employee.setDisponibilites(null);
			   employee.setCompetences(null);
			   employee.setDemandes(null);
			   employee.setDocuments(null);
			   employee.setEthny(null);
			   employee.setExperiences(null);
			   employee.setFormations(null);
			   employee.setLangues(null);
			   employee.setLocalite(null);
			   employee.setNiveauetude(null);
			   employee.setPay(null);
			   employee.setTypeIdentification(null);
			   listeEmployes.add(employee);
			   
			   
		   }
		   return listeEmployes;
		}
		catch(Exception e)
		{
			return null;
		}
	}
   
	@DeleteMapping("/disponibilite/{id}")
	public ResponseEntity<String> deleteDisponibilite(@PathVariable("id") int id) {
		
		try
		{
			   System.out.println("Delete Disponibilite with ID = " + id + "...");
			   disponibiliteRepository.deleteById(id);
			   return new ResponseEntity<>("1", HttpStatus.OK);
		}
		catch(Exception e)
		{
				e.printStackTrace();
				return new ResponseEntity<>("0",HttpStatus.EXPECTATION_FAILED);
		}
	}
	 
	@DeleteMapping("/disponibilite/delete")
	public ResponseEntity<String> deleteAllDisponibilite() {
	    try
		{
			    System.out.println("Delete All Competence...");
			    disponibiliteRepository.deleteAll();
			    return ResponseEntity.status(HttpStatus.OK).body("1");
		}
		catch(Exception e)
		{
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("0");
		}
	}
		
}