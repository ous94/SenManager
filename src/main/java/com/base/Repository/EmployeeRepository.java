package com.base.Repository;

import java.util.List;
import java.util.HashSet;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
	
	//situationMatrimoniale
	  List<Employee> findBySituationMatrimoniale(String situationMatrimoniale);
   //religion
	 List<Employee> findByReligion(String religion);
	//adreese
	List<Employee> findByAdresse(String adresse);
	//Email
	List<Employee> findByEmail(String email);
	
	HashSet<Employee> findByNomOrPrenomOrAdresseOrEmailOrSituationMatrimonialeOrReligionOrObservation(String recherche1,String recherche2,String recherche3,String recherche4,String recherche5,String recherche6,String recherche7);
	@Query("SELECT e FROM Employee e ORDER BY e.idemploye ASC")
     List<Employee> listeEmployeLimiter(Pageable pageable);
	@Query("SELECT e FROM Employee e where e.nom like %:nom% or e.prenom like %:prenom% or e.adresse like %:adresse% "
			+ " or e.email like %:email% or e.situationMatrimoniale like %:situationMatrimoniale% "
			+ " or e.religion like %:religion% or e.observation like %:observation% ORDER BY e.idemploye ASC")
	List<Employee> findByNomOrPrenomOrAdresseOrEmailOrSituationMatrimonialeOrReligionOrObservationPagination(@Param("nom")String recherche1,@Param("prenom") String recherche2, @Param("adresse") 
	String recherche3,@Param("email") String recherche4,@Param("situationMatrimoniale") String recherche5, @Param("religion") String recherche6, @Param("observation") String recherche7,Pageable pageable);
	//
	
	@Query("select employe from Employee employe where "
			+ "employe in (SELECT e FROM Employee e where e.nom like %:nom% or e.prenom like %:prenom% or e.adresse like %:adresse% "
			      + " or e.email like %:email% or e.situationMatrimoniale like %:situationMatrimoniale% "
			      + " or e.religion like %:religion% or e.observation like %:observation%)"
			+"or employe in (SELECT langue.employees from Langue langue where langue.nom like %:languenom%)"
			+"or employe in (SELECT competence.employees FROM Competence competence where competence.description like %:competencedescription%)"
			+"or employe in (SELECT pays.employees FROM Pays pays where pays.nom like %:paysnom%)"
			+"or employe in (SELECT localite.employees FROM Localite localite where localite.nom like %:localitenom%)"
			+"or employe in (SELECT typeIdentification.employees FROM TypeIdentification typeIdentification where typeIdentification.nom like %:typeIdentificationnom%)"
			+"or employe in (SELECT niveauEtude.employees FROM Niveauetude niveauEtude where niveauEtude.niveau like %:niveauEtudeniveau%)"
			+"or employe in (SELECT ethnies.employees FROM Ethnies ethnies where ethnies.nom like %:ethniesnom%)"
			+"or employe in (SELECT disponibilite.employee FROM Disponibilite disponibilite where disponibilite.horaire like %:disponibilitehoraire% or disponibilite.moment like %:disponibilitemoment%)")
	List<Employee>rechercheAllFromEmploye(@Param("nom")String nom,@Param("prenom") String prenom 
		,@Param("adresse")String adresse,@Param("email") String email,@Param("situationMatrimoniale") String situationMatrimoniale
		,@Param("religion")String religion,@Param("observation") String observatioon,@Param("languenom")String languenom
	    ,@Param("competencedescription") String competencedescription,@Param("paysnom")String paysnom
	    ,@Param("localitenom")String localitenom ,@Param("typeIdentificationnom")String typeIdentificationnom
	    ,@Param("niveauEtudeniveau")String niveauEtudeniveau ,@Param("ethniesnom")String ethniesnom
	    ,@Param("disponibilitehoraire")String disponibilitehoraire ,@Param("disponibilitemoment")String disponibilitemoment,Pageable pageable);
	
 }
