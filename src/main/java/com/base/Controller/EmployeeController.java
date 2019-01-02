package com.base.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.base.Entities.Employee;

import com.base.Repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@GetMapping("/employes")
	public Collection<Employee> getAllClients() {
		try
		{
		   System.out.println("Get all Client...");
		   List<Employee> listeEmployes = new ArrayList<>();
		   List<Employee> listeEmp=new ArrayList<>();
		   employeeRepository.findAll().forEach(listeEmployes::add);
		   Employee employee=new Employee();
		   Iterator<Employee> it=listeEmployes.iterator();
		   while(it.hasNext())
		   {
			   Employee emp=it.next();
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
			   listeEmp.add(employee);
		   }
		   return listeEmp;
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
		   //
		    System.out.println("Prenom :"+employe.getPrenom());
		    System.out.println("Nom :"+employe.getNom());
		    System.out.println("Adresse :"+employe.getAdresse());
		    System.out.println("Date de Naisssance :"+employe.getCompetences());
		  //
		    Employee employee=employeeRepository.save(employe);
		    return employee;
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
	
	@GetMapping(value = "employee/situation/{genre}")
	public  List<Employee>  findByNameEndsWith(@PathVariable("genre") String genre) {
		try
		{
		 System.out.println("Get all mesEmploye...");
		   List<Employee> listeEmployes = new ArrayList<>();

		 //List<Employee>  cities =  (List<Employee>)
				 employeeRepository.findByNameEndsWith(genre).forEach(listeEmployes::add);
				 return listeEmployes;
       // return cities;
		}
		catch(Exception e)
		{
			return null;
		}
	}
		
		// retourner par 
/*//		@GetMapping(value = "employee/prenom/{genre}")
//		public String[]  findByAdresse(@PathVariable("genre") String genre) {
//			try
//			{
//			 System.out.println("Get all prenom mesEmploye...");
//			   
//
//			 //List<Employee>  cities =  (List<Employee>)
//			 String[]  listeEmployes =   employeeRepository.findByAdresse(genre);
//					 return listeEmployes;
//	       // return cities;
//			}
//			catch(Exception e)
//			{
//				return null;
//			}
//    }
//		
*/		
	


}

