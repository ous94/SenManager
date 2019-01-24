package com.base.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Client;
import com.base.Entities.Demande;

public interface DemandeRepository extends CrudRepository<Demande,Integer>{
	
	List<Demande> findByServices(String services);
	List<Demande> findByDate(Date date);
	List<Demande> findBySalairePropose(int salairePropose);
	List<Demande> findBySalaireRetenue(int salaireRetenue);
	@Query("SELECT demande from Demande demande where demande.client=:client")
	List<Demande> findByClientPagination(@Param("client")Client client,Pageable pageable);
 
}
