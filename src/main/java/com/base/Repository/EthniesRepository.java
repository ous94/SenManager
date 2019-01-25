package com.base.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Ethnies;

public interface EthniesRepository  extends CrudRepository<Ethnies ,Integer>{
  
	List<Ethnies> findByNom(String nom);
	
	@Query("SELECT e FROM Ethnies e where e.nom like %:nom% order by e.idethnies ASC")
	List<Ethnies> findByNomPagination(@Param("nom")String nom,Pageable pageable);
	
	@Query("SELECT e FROM Ethnies e ")
	List<Ethnies> mesEthnies(Pageable pageable);
}
