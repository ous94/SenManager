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

import com.base.Repository.EmployeeRepository;
import com.base.Entities.Employee;
import com.base.Entities.Localite;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@GetMapping("/employes")
	public List<Employee> getAllClients() {
		try
		{
		   System.out.println("Get all Client...");
		   List<Employee> listeEmployes = new ArrayList<>();
		   employeeRepository.findAll().forEach(listeEmployes::add);
		   return listeEmployes;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@PostMapping(value = "/employes/create")
	public Employee creatEmploye(@RequestBody Employee employe) {
		try
		{
		    employe.setLocalite(new LocaliteController().getLocaliteByNom(employe.getLocalite().getNom()));
		    employe.setTypeIdentification(new TypeIdentificationController().getTypeIdentificationByNom(employe.getTypeIdentification().getNom()));
		    employe.setNiveauetude(new NiveauEtudeController().getNiveauEtudeByNiveau(employe.getNiveauetude().getNiveau()));
		    employe.setEthny(new EthniesController().getEthniesByNom(employe.getEthny().getNom()));
		    employe.setPay(new PaysController().getPaysByNom(employe.getPay().getNom()));
		    
		    //Employee newEmployee=new Employee();
		    Employee employert = employeeRepository.save(employe);
		    return employert;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@DeleteMapping("/employes/{id}")
	public ResponseEntity<String> deleteEmploye(@PathVariable("id") int id) {
		try
		{
		   System.out.println("Delete Employee with ID = " + id + "...");
		   employeeRepository.deleteById(id);
		   return new ResponseEntity<>("Employe has been deleted!", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("", HttpStatus.EXPECTATION_FAILED);
		}
	}

}
