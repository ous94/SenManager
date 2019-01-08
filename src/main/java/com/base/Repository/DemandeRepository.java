package com.base.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Demande;

public interface DemandeRepository extends CrudRepository<Demande,Integer>{
	
	List<Demande> findByServices(String services);
	List<Demande> findByDate(Date date);
	List<Demande> findBySalairePropose(int salairePropose);
	List<Demande> findBySalaireRetenue(int salaireRetenue);
 
}
