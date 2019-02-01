package com.base.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Repository.DemandeRepository;
import com.base.Entities.Client;
import com.base.Entities.Competence;
import com.base.Entities.Demande;
import com.base.Entities.Employee;


@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class DemandeController {
	
	@Autowired
	DemandeRepository demandeRepository;
	
	@PostMapping(value = "/demande/create")
	public Demande creatDemande(@RequestBody Demande demande) {
		try
		{
			String idString=""+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)))+((int) (Math.random()*(9-0)));
            Integer id=java.lang.Integer.valueOf(idString);
		    Demande newDemande=new Demande();
		    System.out.println("Debut Insertion Demande");
		    demande.setIddemande(id);
		    demande.setDate(new Date());
		    Demande  demandert= demandeRepository.save(demande);
		    newDemande.setIddemande(demandert.getIddemande());
		    newDemande.setDate(demande.getDate());
		    newDemande.setServices(demande.getServices());
		    newDemande.setSalairePropose(demandert.getSalairePropose());
		    newDemande.setSalaireRetenue(demandert.getSalaireRetenue());
		    System.out.println("Fin insertion Demande");
		    return newDemande;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/employeeDemande/services/{service}")
	public Set<Employee> getEmployeeDemandeByServices(@PathVariable("services") String services) {
		try
		{
		   System.out.println("Get Employee by Demande.Services");
		   List<Demande> listeDemande = new ArrayList<>();
		   Set<Employee> listeEmployes =new HashSet<>();
		   demandeRepository.findByServices(services).forEach(listeDemande::add);
		   Iterator<Demande> it= listeDemande.iterator();
		   Demande demande=new Demande();
		   while(it.hasNext())
		   {
			   demande=it.next();
			   listeEmployes.addAll(demande.getEmployees());
		   }
		   Employee employee=new Employee();
		   Iterator<Employee> itEmployee=listeEmployes.iterator();
		   while(it.hasNext())
		   {
			   employee=itEmployee.next();
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
		   }
		   return listeEmployes;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/employeeDemande/salaireRetenue/{salaireRetenue}")
	public Set<Employee> getEmployeeDemandeBySalaireRetenue(@PathVariable("salaireRetenue") int salaireRetenue) {
		try
		{
		   System.out.println("Get Employee by Demande.SalaireRetenue");
		   List<Demande> listeDemande = new ArrayList<>();
		   Set<Employee> listeEmployes =new HashSet<>();
		   demandeRepository.findBySalaireRetenue(salaireRetenue).forEach(listeDemande::add);
		   Iterator<Demande> it= listeDemande.iterator();
		   Demande demande=new Demande();
		   while(it.hasNext())
		   {
			   demande=it.next();
			   listeEmployes.addAll(demande.getEmployees());
		   }
		   Employee employee=new Employee();
		   Iterator<Employee> itEmployee=listeEmployes.iterator();
		   while(it.hasNext())
		   {
			   employee=itEmployee.next();
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
		   }
		   return listeEmployes;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/employeeDemande/salairePropose/{salairePropose}")
	public Set<Employee> getEmployeeDemandeBySalairePropose(@PathVariable("salairePropose") int salairePropose) {
		try
		{
		   System.out.println("Get Employee by Demande.SalairePropose");
		   List<Demande> listeDemande = new ArrayList<>();
		   Set<Employee> listeEmployes =new HashSet<>();
		   demandeRepository.findBySalairePropose(salairePropose).forEach(listeDemande::add);
		   Iterator<Demande> it= listeDemande.iterator();
		   Demande demande=new Demande();
		   while(it.hasNext())
		   {
			   demande=it.next();
			   listeEmployes.addAll(demande.getEmployees());
		   }
		   Employee employee=new Employee();
		   Iterator<Employee> itEmployee=listeEmployes.iterator();
		   while(it.hasNext())
		   {
			   employee=itEmployee.next();
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
		   }
		   return listeEmployes;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@GetMapping("/clientDemande/services/{service}")
	public Set<Client> getClientDemandeByServices(@PathVariable("services") String services) {
		try
		{
		   System.out.println("Get Clients by Demande.Services");
		   List<Demande> listeDemande = new ArrayList<>();
		   Set<Client> listeClients =new HashSet<>();
		   demandeRepository.findByServices(services).forEach(listeDemande::add);
		   Iterator<Demande> it= listeDemande.iterator();
		   Demande demande=new Demande();
		   Client client=new Client();
		   while(it.hasNext())
		   {
			   demande=it.next();
			   client=demande.getClient();
			   client.setDemandes(null);
			   client.setDocuments(null);
			   client.setPay(null);
			   client.setLocalite(null);
			   client.setTypeIdentification(null);
			   listeClients.add(client);
		   }
		   
		   return listeClients;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/clientDemande/salaireRetenue/{salaireRetenue}")
	public Set<Client> getClientDemandeBySalaireRetenue(@PathVariable("salaireRetenue") int salaireRetenue) {
		try
		{
		   System.out.println("Get Employee by Demande.Services");
		   List<Demande> listeDemande = new ArrayList<>();
		   Set<Client> listeClients =new HashSet<>();
		   demandeRepository.findBySalaireRetenue(salaireRetenue).forEach(listeDemande::add);
		   Iterator<Demande> it= listeDemande.iterator();
		   Demande demande=new Demande();
		   Client client=new Client();
		   while(it.hasNext())
		   {
			   demande=it.next();
			   client=demande.getClient();
			   client.setDemandes(null);
			   client.setDocuments(null);
			   client.setPay(null);
			   client.setLocalite(null);
			   client.setTypeIdentification(null);
			   listeClients.add(client);
		   }
		   
		   return listeClients;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@GetMapping("/clientDemande/salairePropose/{salairePropose}")
	public Set<Client> getClientDemandeBySalairePropose(@PathVariable("salairePropose") int salairePropose) {
		try
		{
		   System.out.println("Get Clients by Demande.SalairePropose");
		   List<Demande> listeDemande = new ArrayList<>();
		   Set<Client> listeClients =new HashSet<>();
		   demandeRepository.findBySalairePropose(salairePropose).forEach(listeDemande::add);
		   Iterator<Demande> it= listeDemande.iterator();
		   Demande demande=new Demande();
		   Client client=new Client();
		   while(it.hasNext())
		   {
			   demande=it.next();
			   client=demande.getClient();
			   client.setDemandes(null);
			   client.setDocuments(null);
			   client.setPay(null);
			   client.setLocalite(null);
			   client.setTypeIdentification(null);
			   listeClients.add(client);
		   }
		   
		   return listeClients;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@DeleteMapping("/demande/{id}")
	public ResponseEntity<String> deleteDemande(@PathVariable("id") int id) {
		
		try
		{
			   System.out.println("Delete Demande with ID = " + id + "...");
			   demandeRepository.deleteById(id);
			   return new ResponseEntity<>("1", HttpStatus.OK);
		}
		catch(Exception e)
		{
				e.printStackTrace();
				return new ResponseEntity<>("0",HttpStatus.EXPECTATION_FAILED);
		}
	}
	 
	@DeleteMapping("/demande/delete")
	public ResponseEntity<String> deleteAllDemande() {
	    try
		{
			    System.out.println("Delete All Demande...");
			    demandeRepository.deleteAll();
			    return ResponseEntity.status(HttpStatus.OK).body("1");
		}
		catch(Exception e)
		{
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("0");
		}
	}
	
	@GetMapping("/demandes")
	public List<Demande> getAllClients() {
		try
		{
		   System.out.println("Get all Demandes...");
		   List<Demande> listeDemande = new ArrayList<>();
		   demandeRepository.findAll().forEach(listeDemande::add);
		   Iterator<Demande> itDemande=listeDemande.iterator();
		   List<Demande> maListe=new ArrayList<>();
		   while(itDemande.hasNext())
			   
		   {
			   Demande newDemande= new Demande();
			   Demande demande=itDemande.next();
			   newDemande.setIddemande(demande.getIddemande());
			   newDemande.setDate(demande.getDate());
			   newDemande.setServices(demande.getServices());
			   newDemande.setSalairePropose(demande.getSalairePropose());
			   newDemande.setSalaireRetenue(demande.getSalaireRetenue());
			   HashSet<Employee> mesemployee= new HashSet<Employee>();
			   Iterator<Employee> itemp= demande.getEmployees().iterator();
			   HashSet<Competence> mescompetence = new HashSet<>();
			   Iterator<Competence> itcomp = demande.getCompetences().iterator();
			   while(itemp.hasNext())
			   {
				   Employee employee=new Employee();
				   Employee emp=itemp.next();
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
				   mesemployee.add(employee);
			   }
			   while(itcomp.hasNext())
			   {
				   Competence comp= itcomp.next();
				   comp.setDemandes(null);
				   comp.setEmployees(null);
				   mescompetence.add(comp);

			   }
			   Client clients = demande.getClient();
			   Client cli = new Client();
			   

			   if(clients != null)
			   {
				   cli.setNom(clients.getPrenom());
				   cli.setPrenom(clients.getPrenom());
				   cli.setIdclient(clients.getIdclient());
				   cli.setEmail(clients.getEmail());
				   
			   }
			    newDemande.setCompetences(mescompetence);
			    newDemande.setClient(cli);
			   
			    newDemande.setEmployees(mesemployee);
			   			   
			   
			   
		       maListe.add(newDemande);
		   }
		   return maListe;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@PutMapping("/demande/editer/{id}")
	public ResponseEntity<Demande> updateCustomer(@PathVariable("id") int id, @RequestBody Demande demande) {
		
		try
		{
		System.out.println("Update Customer with ID = " + id + "...");
		Optional<Demande> demandeData = demandeRepository.findById(id);
		    
		    
		    if (demandeData.isPresent()) {
				Demande _demande = demandeData.get();
			    _demande.setServices(demande.getServices());
			    _demande.setIddemande(demande.getIddemande());
			    _demande.setSalairePropose(demande.getSalairePropose());
			    _demande.setSalaireRetenue(demande.getSalaireRetenue());
				demandeRepository.save(_demande);
				
				return new ResponseEntity<>(demandeRepository.save(_demande), HttpStatus.OK);
			} else {
				return null;
			}
		}catch(Exception e)
		{
			return null;
		}
	}
	
	//conter
			@GetMapping("/demande/nombre")				
			public int conter()
			{
			try {
					int nombre = (int) demandeRepository.count();
					if(nombre<0)
					{
						return 0;
					}else
					   return nombre;
					
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}
			

}
