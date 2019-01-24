package com.base.Repository;

import java.util.List;
import java.util.HashSet;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Disponibilite;

public interface DisponibiliteRepository extends CrudRepository<Disponibilite ,Integer>{
	
	List<Disponibilite> findByHoraire(String horaire);
	List<Disponibilite> findByMoment(String moment);
	HashSet<Disponibilite> findByHoraireOrMoment(String recherche1 ,String recherche2);
	@Query("SELECT d FROM Disponibilite d where d.horaire like %:horaire% or d.moment like %:moment% order by d.iddisponibilite ASC")
	List<Disponibilite> findByHoraireOrMomentPagition(@Param("horaire")String horaire,@Param("moment") String moment,Pageable pageable);

}
