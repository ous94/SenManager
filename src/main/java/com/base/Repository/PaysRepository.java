package com.base.Repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Pays;


public interface PaysRepository extends CrudRepository<Pays,Integer> {
	
	List<Pays> findByNom(String nom);
	@Query("SELECT p FROM Pays p where p.nom like %:nom% order by p.idpays ASC")
	List<Pays> findByNomPagination(@Param("nom")String nom ,Pageable pageable);
	
	@Query("SELECT p FROM Pays p")
	List<Pays> mesPays(PageRequest pageRequest);





}
