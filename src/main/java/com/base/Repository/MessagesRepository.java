package com.base.Repository;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Messages;

public interface MessagesRepository extends CrudRepository<Messages,Integer> {

}
