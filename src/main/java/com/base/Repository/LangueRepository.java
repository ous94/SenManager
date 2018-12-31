package com.base.Repository;

import java.util.List;



import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Langue;

public interface LangueRepository extends CrudRepository<Langue ,Integer>{

	List<Langue> findByNom(String nom);
}
