package com.base.Repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Disponibilite;

public interface DisponibiliteRepository extends CrudRepository<Disponibilite ,Integer>{
	
	List<Disponibilite> findByHoraire(String horaire);
	List<Disponibilite> findByMoment(String moment);

}
