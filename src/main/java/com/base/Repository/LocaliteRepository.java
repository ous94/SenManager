package com.base.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Localite;

import java.util.HashSet;
import java.util.List;

public interface LocaliteRepository extends CrudRepository<Localite,Integer>{
	
	List<Localite> findByNom(String nom);
	@Query("SELECT l FROM Localite l where l.nom like %:nom% order by l.idlocalite ASC")
	List<Localite> findByNomPagination(@Param("nom") String nom ,Pageable pageable);

}
