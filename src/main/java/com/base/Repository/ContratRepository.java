package com.base.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Contrat;
import com.base.Entities.Demande;
import com.base.Entities.Employee;

public interface ContratRepository extends CrudRepository<Contrat,Integer>{
	
	@Query("SELECT contrat from Contrat contrat ORDER BY contrat.debut DESC")
	List<Contrat> findAllContratPagination(Pageable pageable);
	
	@Query("SELECT contrat from Contrat contrat where contrat.employee=:employee ORDER BY contrat.debut DESC")
	List<Contrat> findByEmployeePagination(@Param("employee") Employee employee, Pageable pageable);
	
	@Query("SELECT contrat from Contrat contrat where contrat.demande=:demande ORDER BY contrat.debut DESC")
	List<Contrat> findByDemandePagination(@Param("demande") Demande demande ,Pageable pageable);
	
	@Query("SELECT contrat from Contrat contrat where contrat.fin=:fin or contrat.debut=:debut or contrat.salaire=:salaire ORDER BY contrat.debut DESC")
	List<Contrat> rechercheContratPagination(@Param("fin") Date fin,@Param("debut") Date debut,@Param("salaire") int salaire,Pageable pageable);
	
	@Query("SELECT contrat.demande from Contrat contrat where contrat.idContrat=:idContrat")
	Demande contratDemande(@Param("idContrat") int idContrat);
	
	@Query("SELECT contrat.employee from Contrat contrat where contrat.idContrat=:idContrat")
	Employee contratEmployee(@Param("idContrat") int idContrat);

}
