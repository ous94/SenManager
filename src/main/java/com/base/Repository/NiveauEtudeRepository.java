package com.base.Repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Niveauetude;

public interface NiveauEtudeRepository extends CrudRepository<Niveauetude,Integer> {
	
	List<Niveauetude> findByNiveau(String nom);


}
