package com.base.Controller;

import java.util.ArrayList;
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

import com.base.Repository.TypeIdentificationRepository;
import com.base.Entities.TypeIdentification;

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

}
