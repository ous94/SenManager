package com.base.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Ethnies;

public interface EthniesRepository  extends CrudRepository<Ethnies ,Integer>{
  
	List<Ethnies> findByNom(String nom);
}
