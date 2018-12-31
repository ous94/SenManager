package com.base.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Competence;

public interface ComptenceRepository extends CrudRepository<Competence ,Integer> {

	public Competence findByDescription(String description);

	//public List<Competence> findByAge(String description);

}
