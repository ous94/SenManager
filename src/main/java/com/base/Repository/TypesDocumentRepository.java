package com.base.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.TypesDocument;

public interface TypesDocumentRepository extends CrudRepository<TypesDocument,Integer> {
	
	List<TypesDocument> findByNom(String nom);

}
