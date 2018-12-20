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

import com.base.Repository.EthniesRepository;
import com.base.Entities.Ethnies;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class EthniesController {
	
	@Autowired
	EthniesRepository ethniesRepository;
	@GetMapping("/ethnies")
	public List<Ethnies> getAllEthnies() {
		try
		{
		   System.out.println("Get all Ethnies...");
		   List<Ethnies> listeEthnies = new ArrayList<>();
		   ethniesRepository.findAll().forEach(listeEthnies::add);
		   return listeEthnies;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@PostMapping(value = "/ethnies/create")
	public Ethnies creatClient(@RequestBody Ethnies ethnies) {
		try
		{
		    Ethnies newEthnies=new Ethnies();
		    Ethnies ethniesrt = ethniesRepository.save(newEthnies);
		    return ethniesrt;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@DeleteMapping("/ethnies/{id}")
	public ResponseEntity<String> deleteEthnies(@PathVariable("id") int id) {
		try
		{
		   System.out.println("Delete Ethnie with ID = " + id + "...");
		   ethniesRepository.deleteById(id);
		   return new ResponseEntity<>("Client has been deleted!", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("", HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/ethnies/nom")
	public List<String> getAllnomEthnies() {
		try
		{
		   System.out.println("Get all Ethnies...");
		   List<Ethnies> listeEthnies = new ArrayList<>();
		   ethniesRepository.findAll().forEach(listeEthnies::add);
		   List<String> nomethnies = new ArrayList<>();
		   Iterator<Ethnies> it= listeEthnies.iterator();
		   while(it.hasNext())
		   {
			   nomethnies.add(it.next().getNom());
			   
			   
		   }
		   return nomethnies;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
