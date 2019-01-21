package com.base.Controller;

import java.util.HashSet;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Entities.Client;
import com.base.Entities.Competence;
import com.base.Entities.Disponibilite;
import com.base.Entities.Employee;
import com.base.Entities.Ethnies;
import com.base.Entities.Langue;
import com.base.Entities.Localite;
import com.base.Entities.Niveauetude;
import com.base.Entities.Pays;
import com.base.Entities.TypeIdentification;
import com.base.Repository.ClientRepository;
import com.base.Repository.ComptenceRepository;
import com.base.Repository.DisponibiliteRepository;
import com.base.Repository.EmployeeRepository;
import com.base.Repository.EthniesRepository;
import com.base.Repository.LangueRepository;
import com.base.Repository.LocaliteRepository;
import com.base.Repository.NiveauEtudeRepository;
import com.base.Repository.PaysRepository;
import com.base.Repository.TypeIdentificationRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class RechercheClient {

	@Autowired
	PaysRepository paysRepository;
	@Autowired
	LocaliteRepository localiteRepository;
	@Autowired
	TypeIdentificationRepository typeIdentificationRepository;
	@Autowired
	ClientRepository  clientRepository;
	
	@GetMapping("/recherche/tousClients/{recherche}")
	public HashSet<Client> rechercheClients (@PathVariable("recherche") String recherche)
	{
		try
		{
			HashSet<Localite> listeLocalite=new HashSet<Localite>();
			HashSet<Pays> listePays =new HashSet<Pays>();
			HashSet<TypeIdentification> listeTypeIdentification=new HashSet<TypeIdentification>();
			HashSet<Client> listeClient=new HashSet<Client>();
			//
			localiteRepository.findByNom(recherche).forEach(listeLocalite::add);
			paysRepository.findByNom(recherche).forEach(listePays::add);
			typeIdentificationRepository.findByNom(recherche).forEach(listeTypeIdentification::add);
			clientRepository.findByNomOrPrenomOrAdresseOrEmailOrObservationOrSexe(recherche, recherche, recherche, recherche, recherche, recherche).forEach(listeClient::add);
			Iterator<Localite> itLocalite=listeLocalite.iterator();
			Iterator<Pays> itPays=listePays.iterator();
			Iterator<TypeIdentification> itTypeIdentification=listeTypeIdentification.iterator();
	
			while(itLocalite.hasNext())
			{
				Localite localite=itLocalite.next();
				listeClient.addAll(localite.getClients());
			}
			while(itPays.hasNext())
			{
				Pays pays=itPays.next();
				listeClient.addAll(pays.getClients());
			}
			while(itTypeIdentification.hasNext())
			{
				TypeIdentification typeIdentification=itTypeIdentification.next();
				listeClient.addAll(typeIdentification.getClients());
			}

			HashSet<Client> listeClientFinal=new HashSet<Client>();
			Iterator<Client> it=listeClient.iterator();
		    while(it.hasNext())
			   {
				   Client employee=new Client();
				   Client emp=it.next();
				   employee.setIdclient(emp.getIdclient());
				   employee.setAdresse(emp.getAdresse());
				   employee.setEmail(emp.getEmail());
				   employee.setLogin(emp.getLogin());
				   employee.setIdentification(emp.getIdentification());
				   employee.setNom(emp.getNom());
				   employee.setObservation(emp.getObservation());
				   employee.setPrenom(emp.getPrenom());
				   employee.setLogin(emp.getLogin());
				   employee.setPassword(emp.getPassword());
				   employee.setTelephoneFixe(emp.getTelephoneFixe());
				   employee.setTelephoneMobile(emp.getTelephoneMobile());
				   Pays pays=emp.getPay();
				   Localite localite =emp.getLocalite();
				   TypeIdentification typedentification=emp.getTypeIdentification();
				   Pays pys=new Pays();
				   Localite local= new Localite();
				   TypeIdentification typ = new TypeIdentification();

				  if(pays !=null) 
				    {
					   pys.setIdpays(pays.getIdpays());
					   pys.setNom(pays.getNom());
				    }
				  if(localite!=null)
				  {
					  local.setIdlocalite(localite.getIdlocalite());
					  local.setNom(localite.getNom());
					  
				  }
				  if(typedentification !=null)
				  {
					  typ.setIdidentification(typedentification.getIdidentification());
					  typ.setNom(typedentification.getNom());
				  }

				   employee.setPay(pys);
				   employee.setLocalite(local);
				   employee.setTypeIdentification(typ);
				   
				   listeClientFinal.add(employee);
			   }
			
			
			return listeClientFinal;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

}
