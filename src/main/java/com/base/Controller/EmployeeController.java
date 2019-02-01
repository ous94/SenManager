package com.base.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
import com.base.Entities.Contrat;
import com.base.Entities.Disponibilite;
import com.base.Entities.Employee;
import com.base.Entities.Ethnies;
import com.base.Entities.Langue;
import com.base.Entities.Niveauetude;
import com.base.Entities.Pays;
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
	//Get All Employes avec plus de Details
	@GetMapping("/allemployes")
	public HashSet<Employee> getAllEmployess() {
		try
		{
			System.out.println("Get All Employe Detail");
		   HashSet<Employee> listeEmployes = new HashSet<Employee>();
		   HashSet<Employee> listeEmp=new HashSet<Employee>();
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
			   Iterator<Competence> itCompetence=emp.getCompetences().iterator();
			   Iterator<Disponibilite> itDisponibilite=emp.getDisponibilites().iterator();
			   Iterator<Langue> itLangue=emp.getLangues().iterator();
			   HashSet<Competence>setCompetence=new HashSet<Competence>();
			   HashSet<Langue> setLangue=new HashSet<Langue>();
			   HashSet<Disponibilite> setDisponibilite=new HashSet<Disponibilite>();
			   HashSet<Contrat> newListeContrat =new HashSet<Contrat>();
			   Ethnies ethnie=emp.getEthny();
			   Niveauetude niveauEtude=emp.getNiveauetude();
			   Pays pays=emp.getPay();
			   while(itCompetence.hasNext())
			   {
				   Competence comp=itCompetence.next();
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
			   if(ethnie !=null) {
			   ethnies.setIdethnies(ethnie.getIdethnies());
			   ethnies.setNom(ethnie.getNom());
			   }
			   if(niveauEtude !=null) {
			   niveau.setIdniveau(niveauEtude.getIdniveau());
			   niveau.setNiveau(niveauEtude.getNiveau());
			   }
			   if(pays !=null) {
			       pys.setIdpays(pays.getIdpays());
			   pys.setNom(pays.getNom());
			   }
			   Iterator<Contrat> itContrat=emp.getContrats().iterator();
			   while(itContrat.hasNext())
			   {
					Contrat contrat=itContrat.next();
					Contrat newContrat=new Contrat();
					newContrat.setDebut(contrat.getDebut());
					newContrat.setFin(contrat.getFin());
					newContrat.setSalaire(contrat.getSalaire());
					newContrat.setIdContrat(contrat.getIdContrat());
					newListeContrat.add(newContrat);
			  }
			   employee.setCompetences(setCompetence);
			   employee.setDisponibilites(setDisponibilite);
			   employee.setLangues(setLangue);
			   employee.setPay(pys);
			   employee.setEthny(ethnies);
			   employee.setNiveauetude(niveau);
			   employee.setContrats(newListeContrat);
			   listeEmp.add(employee);
		   }
		   return listeEmp;
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
				@SuppressWarnings("deprecation")
				@GetMapping("/allEmploye/pagination/{offset}")
				HashSet<Employee> listeEmployeLimite(@PathVariable("offset")int offset)
				{
					try
					{
					   HashSet<Employee> listeEmployee=new HashSet<Employee>();
					   HashSet<Employee> listeEmp=new HashSet<Employee>();
					   employeeRepository.listeEmployeLimiter(new PageRequest(offset,2)).forEach(listeEmployee::add);
					   Iterator<Employee> it=listeEmployee.iterator();
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
						   Iterator<Competence> itCompetence=emp.getCompetences().iterator();
						   Iterator<Disponibilite> itDisponibilite=emp.getDisponibilites().iterator();
						   Iterator<Langue> itLangue=emp.getLangues().iterator();
						   HashSet<Competence>setCompetence=new HashSet<Competence>();
						   HashSet<Langue> setLangue=new HashSet<Langue>();
						   HashSet<Disponibilite> setDisponibilite=new HashSet<Disponibilite>();
						   Ethnies ethnie=emp.getEthny();
						   Niveauetude niveauEtude=emp.getNiveauetude();
						   Pays pays=emp.getPay();
						   while(itCompetence.hasNext())
						   {
							   Competence comp=itCompetence.next();
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
						   if(ethnie !=null) {
						   ethnies.setIdethnies(ethnie.getIdethnies());
						   ethnies.setNom(ethnie.getNom());
						   }
						   if(niveauEtude !=null) {
						   niveau.setIdniveau(niveauEtude.getIdniveau());
						   niveau.setNiveau(niveauEtude.getNiveau());
						   }
						   if(pays !=null) {
						       pys.setIdpays(pays.getIdpays());
						   pys.setNom(pays.getNom());
						   }
						   employee.setCompetences(setCompetence);
						   employee.setDisponibilites(setDisponibilite);
						   employee.setLangues(setLangue);
						   employee.setPay(pys);
						   employee.setEthny(ethnies);
						   employee.setNiveauetude(niveau);
						   listeEmp.add(employee);
					   }
					   return listeEmp;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						return null;
					}
				}
				@GetMapping("/employe/nouveau/count")
				int employeNouveauCount()
				{
					try
					{
						return employeeRepository.countEmployeNouveau();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						return 0;
					}
				}
				@GetMapping("/employe/libre/count")
				int employeLibreCount()
				{
					try
					{
						Date date=new Date();
						return employeeRepository.countEmployeLibre(date);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						return 0;
					}
				}
				
}
