package com.base.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Langue;

public interface LangueRepository extends CrudRepository<Langue ,Integer>{

	List<Langue> findByNom(String nom);
	@Query("SELECT l FROM Langue l where l.nom like %:nom% order by l.idlangue ASC")
	List<Langue> findByNomPagination(@Param("nom") String nom,Pageable pageable);
}
