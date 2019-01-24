package com.base.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Niveauetude;

public interface NiveauEtudeRepository extends CrudRepository<Niveauetude,Integer> {
	
	List<Niveauetude> findByNiveau(String nom);
	
	@Query("SELECT n FROM Niveauetude n where n.niveau like %:niveau% order by n.idniveau ASC")
	List<Niveauetude>findByNiveauPagination(@Param("niveau") String niveau,Pageable pageable);


}
