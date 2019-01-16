package com.base.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Client;

public interface ClientRepository extends CrudRepository<Client,Integer> {
	
	List<Client> findByLoginAndPassword(String login,String password);

}
