package com.base.Repository;

import java.util.HashSet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Client;

public interface ClientRepository extends CrudRepository<Client,Integer> {
	
	List<Client> findByLoginAndPassword(String login,String password);

	HashSet<Client> findByNomOrPrenomOrAdresseOrEmailOrObservationOrSexe(String recherche, String recherche2,
			String recherche3, String recherche4, String recherche5,String recherche6);

}
