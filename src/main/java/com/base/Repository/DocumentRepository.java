package com.base.Repository;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Document;

public interface DocumentRepository extends CrudRepository<Document ,Integer> {

}
