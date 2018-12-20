package com.base.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.TypeIdentification;

public interface TypeIdentificationRepository extends CrudRepository<TypeIdentification,Integer> {
	
	List<TypeIdentification> findByNom(String nom);

}
