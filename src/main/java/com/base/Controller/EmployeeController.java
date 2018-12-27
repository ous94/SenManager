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

import com.base.Entities.Competence;
import com.base.Entities.Employee;
import com.base.Entities.Langue;
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
		/*System.out.println(employe.getNom());
		System.out.println(employe.getAdresse());
		System.out.println(employe.getPrenom());
		System.out.println(employe.getDateNaissance());
		System.out.println(employe.getEmail());
		System.out.println(employe.getPay());

		Iterator<Langue> i=employe.getLangues().iterator();
		while( i.hasNext())
		{
			System.out.println(i.next().getNom());
		}
		Iterator<Competence> c=employe.getCompetences().iterator();
		while( i.hasNext())
		{
			System.out.println(c.next().getDescription());
		}*/
		try
		{
		 System.out.println("Get all Client..."+employe.getEmail());

			Employee newEmployee =new Employee();
			//String id=""+Math.random()*(0-9)+employe.getTelephoneMobile()+Math.random()*(0-9);
			
			Integer idemploye=new Integer("1");
			
			newEmployee.setIdemploye(idemploye);
			
			newEmployee.setLocalite(new LocaliteController().getLocaliteByNom(employe.getLocalite().getNom()));
			newEmployee.setTypeIdentification(new TypeIdentificationController().getTypeIdentificationByNom(employe.getTypeIdentification().getNom()));
			newEmployee.setNiveauetude(new NiveauEtudeController().getNiveauEtudeByNiveau(employe.getNiveauetude().getNiveau()));
			newEmployee.setEthny(new EthniesController().getEthniesByNom(employe.getEthny().getNom()));
			newEmployee.setPay(new PaysController().getPaysByNom(employe.getPay().getNom()));
			newEmployee.setNom(employe.getNom());
			newEmployee.setPrenom(employe.getPrenom());
			newEmployee.setDateNaissance(employe.getDateNaissance());
			newEmployee.setAdresse(employe.getAdresse());
			newEmployee.setTelephoneMobile(employe.getTelephoneMobile());
			newEmployee.setTelephoneFixe(employe.getTelephoneFixe());
			newEmployee.setEmail(employe.getEmail());
			newEmployee.setSituationMatrimoniale(employe.getSituationMatrimoniale());
			newEmployee.setReligion(employe.getReligion());
			newEmployee.setIdentification(employe.getIdentification());
			newEmployee.setObservation(employe.getObservation());
			newEmployee.setPhoto(employe.getPhoto());
			newEmployee.setCompetences(null);
			newEmployee.setLangues(null);
			/*List<Competence> listeCmpetences=new ArrayList();
			CompetenceController compController=new CompetenceController();
			Iterator<Competence> itcomp=employe.getCompetences().iterator();
			while(itcomp.hasNext())
			{
				Competence comp=compController.getComptenceByDescription(itcomp.next().getDescription());
				System.out.println(comp.getDescription());
				listeCmpetences.add(comp);
			}
			newEmployee.setCompetences(listeCmpetences);*/
			
		   
		    Employee employert = employeeRepository.save(employe);
		    return employert;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	@PostMapping(value = "/customers/create")
	public Employee postCustomer(@RequestBody Employee employe) {
		 System.out.println("Get all Client..."+employe.getEmail());

			Employee newEmployee =new Employee();
			String id=""+Math.random()*(0-9)+employe.getTelephoneMobile()+Math.random()*(0-9);
			
			Integer idemploye=new Integer(id);
			
			newEmployee.setIdemploye(idemploye);
 
		Employee _customer = 
				employeeRepository.save(new Employee());
		return _customer;
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
