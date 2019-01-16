package com.base.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	public List<Employee> getAllClients() {
		try
		{
		   System.out.println("Get all Client...");
		   List<Employee> listeEmployes = new ArrayList<>();
		   List<Employee> listeEmp=new ArrayList<>();
		   employeeRepository.findAll().forEach(listeEmployes::add);
		   Iterator<Employee> it=listeEmployes.iterator();
		   while(it.hasNext())
		   {
			   Employee employee=new Employee();

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
			String idString=""+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)));
            Integer id=java.lang.Integer.valueOf(idString);
            employe.setIdemploye(id);
			Employee emp=employeeRepository.save(employe);
			Employee employee=new Employee();
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
			employee.setLangues(emp.getLangues());
			employee.setSituationMatrimoniale(emp.getSituationMatrimoniale());
			
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
	
/*	@GetMapping(value = "employee/situation/{genre}")
	public  List<Employee>  findByNameEndsWith(@PathVariable("situation_matrimoniale") String situation_matrimoniale) {
		try
		{
		   System.out.println("Get all employye genre...");
		   List<Employee> listeEmployes = new ArrayList<>();
		   List<Employee> listeEmp=new ArrayList<>();
		   employeeRepository.findBySituationMatrimoniale(situation_matrimoniale).forEach(listeEmployes::add);
		   Iterator<Employee> it=listeEmployes.iterator();
		   while(it.hasNext())
		   {
			   Employee employee=new Employee();

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

    
	}*/
		
		// retourner par 
/*//		@GetMapping(value = "employee/prenom/{genre}")
//		public String[]  findByAdresse(@PathVariable("genre") String genre) {
//			try
//			{
//			 System.out.println("Get all prenom mesEmploye...");
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
 * 
//		
*/
	//SituationMatrimoniale
	@GetMapping("/employes/{situationMatrimoniale}")
	public List<Employee> getEmployeBySituation(@PathVariable("situationMatrimoniale") String situationMatrimoniale) {
		try
		{
		   System.out.println("Get all employeeby Situation...");
		   List<Employee> listeEmployes = new ArrayList<>();
		   List<Employee> listeEmp=new ArrayList<>();
		   employeeRepository.findBySituationMatrimoniale(situationMatrimoniale).forEach(listeEmployes::add);
		   Iterator<Employee> it=listeEmployes.iterator();
		   while(it.hasNext())
		   {
			   Employee employee=new Employee();

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
	
	//Religion
		@GetMapping("/employes/religion/{religion}")
		public List<Employee> getEmployereligion(@PathVariable("religion") String religion) {
			try
			{
			   System.out.println("Get all employe by Religion...");
			   List<Employee> listeEmployes = new ArrayList<>();
			   List<Employee> listeEmp=new ArrayList<>();
			   employeeRepository.findByReligion(religion).forEach(listeEmployes::add);
			   Iterator<Employee> it=listeEmployes.iterator();
			   while(it.hasNext())
			   {
				   Employee employee=new Employee();

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
		//Adresse
				@GetMapping("/employes/adresse/{adresse}")
				public List<Employee> getEmployeadresse(@PathVariable("adresse") String adresse) {
					try
					{
					   System.out.println("Get all employe by adresse...");
					   List<Employee> listeEmployes = new ArrayList<>();
					   List<Employee> listeEmp=new ArrayList<>();
					   employeeRepository.findByAdresse(adresse).forEach(listeEmployes::add);
					   Iterator<Employee> it=listeEmployes.iterator();
					   while(it.hasNext())
					   {
						   Employee employee=new Employee();

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
				
				//Email
				@GetMapping("/employes/email/{email}")
				public List<Employee> getEmployemail(@PathVariable("email") String email) {
					try
					{
					   System.out.println("Get all employe by Email...");
					   List<Employee> listeEmployes = new ArrayList<>();
					   List<Employee> listeEmp=new ArrayList<>();
					   employeeRepository.findByEmail(email).forEach(listeEmployes::add);
					   Iterator<Employee> it=listeEmployes.iterator();
					   while(it.hasNext())
					   {
						   Employee employee=new Employee();
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
}
