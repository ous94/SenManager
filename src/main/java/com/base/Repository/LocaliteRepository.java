package com.base.Repository;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Localite;

import java.util.List;

public interface LocaliteRepository extends CrudRepository<Localite,Integer>{
	
	List<Localite> findByNom(String nom);

}
