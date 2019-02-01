package com.base.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Localite;

public interface LocaliteRepository extends CrudRepository<Localite,Integer>{
	
	List<Localite> findByNom(String nom);
	@Query("SELECT l FROM Localite l where l.nom like %:nom% order by l.idlocalite ASC")
	List<Localite> findByNomPagination(@Param("nom") String nom ,Pageable pageable);
	
	@Query("SELECT l FROM Localite l order by l.idlocalite ASC")
	List<Localite> mesLocalites(Pageable pageable);

}
