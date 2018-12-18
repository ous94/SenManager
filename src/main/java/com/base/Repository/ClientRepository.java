package com.base.Repository;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Client;

public interface ClientRepository extends CrudRepository<Client,Integer> {

}
