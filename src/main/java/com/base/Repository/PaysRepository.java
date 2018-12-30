package com.base.Repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Pays;


public interface PaysRepository extends CrudRepository<Pays,Integer> {
	
	Pays findByNom(String nom);




}
