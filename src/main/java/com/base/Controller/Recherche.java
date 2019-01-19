package com.base.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

import com.base.Repository.*;
import com.base.Entities.*;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class Recherche {
	
	@Autowired
	ComptenceRepository competenceRepository;
	@Autowired
	EmployeeRepository employeRepository;
	@Autowired
	PaysRepository paysRepository;
	@Autowired 
	LangueRepository langueRepository;
	@Autowired 
	EthniesRepository ethniesRepository;
	@Autowired 
	DisponibiliteRepository disponibiliteRepository;
	@Autowired
	LocaliteRepository localiteRepository;
	@Autowired
	TypeIdentificationRepository typeIdentificationRepository;
	@Autowired
	NiveauEtudeRepository niveauEtudeRepository;
	
	@GetMapping("/recherche/tous/{recherche}")
	public HashSet<Employee> rechercheEmployes (@PathVariable("recherche") String recherche)
	{
		try
		{
			HashSet<Langue> listeLangue=new HashSet<Langue>();
			HashSet<Localite> listeLocalite=new HashSet<Localite>();
			HashSet<Pays> listePays =new HashSet<Pays>();
			HashSet<Competence> listeCompetence=new HashSet<Competence>();
			HashSet<Ethnies> listeEthnie=new HashSet<Ethnies>();
			HashSet<Disponibilite> listeDisponibilite =new HashSet<Disponibilite>();
			HashSet<Niveauetude> listeNiveauEtude=new HashSet<Niveauetude>();
			HashSet<TypeIdentification> listeTypeIdentification=new HashSet<TypeIdentification>();
			HashSet<Employee> listeEmploye=new HashSet<Employee>();
			//
			competenceRepository.findByDescription(recherche).forEach(listeCompetence::add);
			localiteRepository.findByNom(recherche).forEach(listeLocalite::add);
			paysRepository.findByNom(recherche).forEach(listePays::add);
			langueRepository.findByNom(recherche).forEach(listeLangue ::add);
			ethniesRepository.findByNom(recherche).forEach(listeEthnie::add);
			disponibiliteRepository.findByHoraireOrMoment(recherche,recherche).forEach(listeDisponibilite::add);
			niveauEtudeRepository.findByNiveau(recherche).forEach(listeNiveauEtude::add);
			typeIdentificationRepository.findByNom(recherche).forEach(listeTypeIdentification::add);
			employeRepository.findByNomOrPrenomOrAdresseOrEmailOrSituationMatrimonialeOrReligionOrObservation(recherche,recherche,recherche,recherche,recherche,recherche,recherche).forEach(listeEmploye::add);
			Iterator<Competence> itCompetence=listeCompetence.iterator();
			Iterator<Localite> itLocalite=listeLocalite.iterator();
			Iterator<Pays> itPays=listePays.iterator();
			Iterator<Ethnies>itEthnie=listeEthnie.iterator();
			Iterator<Disponibilite> itDisponibilite=listeDisponibilite.iterator();
			Iterator<TypeIdentification> itTypeIdentification=listeTypeIdentification.iterator();
			Iterator<Niveauetude> itNiveauEtude=listeNiveauEtude.iterator();
			Iterator<Langue> itLangue=listeLangue.iterator();
			while(itCompetence.hasNext())
			{
				Competence competence=itCompetence.next();
				listeEmploye.addAll(competence.getEmployees());
			}
			while(itLocalite.hasNext())
			{
				Localite localite=itLocalite.next();
				listeEmploye.addAll(localite.getEmployees());
			}
			while(itPays.hasNext())
			{
				Pays pays=itPays.next();
				listeEmploye.addAll(pays.getEmployees());
			}
			while(itEthnie.hasNext())
			{
				Ethnies ethnies=itEthnie.next();
				listeEmploye.addAll(ethnies.getEmployees());
			}
			while(itDisponibilite.hasNext())
			{
				Disponibilite disponibilite=itDisponibilite.next();
				listeEmploye.add(disponibilite.getEmployee());
			}
			while(itTypeIdentification.hasNext())
			{
				TypeIdentification typeIdentification=itTypeIdentification.next();
				listeEmploye.addAll(typeIdentification.getEmployees());
			}
			while(itNiveauEtude.hasNext())
			{
				Niveauetude niveauEtude=itNiveauEtude.next();
				listeEmploye.addAll(niveauEtude.getEmployees());
			}
			while(itLangue.hasNext())
			{
				Langue langue=itLangue.next();
				listeEmploye.addAll(langue.getEmployees());
			}
			HashSet<Employee> listeEmployeFinal=new HashSet<Employee>();
			Iterator<Employee> it=listeEmploye.iterator();
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
				   Iterator<Competence> itCompetences=emp.getCompetences().iterator();
				   Iterator<Disponibilite> itDisponibilites=emp.getDisponibilites().iterator();
				   Iterator<Langue> itLangues=emp.getLangues().iterator();
				   HashSet<Competence>setCompetence=new HashSet<Competence>();
				   HashSet<Langue> setLangue=new HashSet<Langue>();
				   HashSet<Disponibilite> setDisponibilite=new HashSet<Disponibilite>();
				   Ethnies ethnie=emp.getEthny();
				   Niveauetude niveauEtude=emp.getNiveauetude();
				   Pays pays=emp.getPay();
				   Localite localite =emp.getLocalite();
				   TypeIdentification typedentification=emp.getTypeIdentification();
				   while(itCompetences.hasNext())
				   {
					   Competence comp=itCompetences.next();
					   comp.setDemandes(null);
					   comp.setEmployees(null);
					   setCompetence.add(comp);
				   }
				   while(itDisponibilites.hasNext())
				   {
					   Disponibilite dispo=itDisponibilites.next();
					   dispo.setEmployee(null);
					   setDisponibilite.add(dispo);
				   }
				   while(itLangues.hasNext())
				   {
					  Langue lang=itLangues.next();
					  lang.setEmployees(null);
					  setLangue.add(lang);
				   }
				   Ethnies ethnies=new Ethnies();
				   Niveauetude niveau=new Niveauetude();
				   Pays pys=new Pays();
				   Localite local= new Localite();
				   TypeIdentification typ = new TypeIdentification();
				   if(ethnie !=null)
				   {
					   ethnies.setIdethnies(ethnie.getIdethnies());
					   ethnies.setNom(ethnie.getNom());
					}
			       if(niveauEtude !=null)
					{
					   niveau.setIdniveau(niveauEtude.getIdniveau());
					   niveau.setNiveau(niveauEtude.getNiveau());
					}
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
				   employee.setCompetences(setCompetence);
				   employee.setDisponibilites(setDisponibilite);
				   employee.setLangues(setLangue);
				   employee.setPay(pys);
				   employee.setEthny(ethnies);
				   employee.setNiveauetude(niveau);
				   employee.setLocalite(local);
				   employee.setTypeIdentification(typ);
				   
				   listeEmployeFinal.add(employee);
			   }
			
			
			return listeEmployeFinal;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

}
