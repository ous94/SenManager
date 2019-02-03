package com.base.Repository;

import java.util.HashSet;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Client;

public interface ClientRepository extends CrudRepository<Client,Integer> {
	
	 public List<Client> findByLoginAndPassword(String login,String password);

	 public HashSet<Client> findByNomOrPrenomOrAdresseOrEmailOrObservationOrSexe(String recherche, String recherche2,
			String recherche3, String recherche4, String recherche5,String recherche6);
     @Query("Select c from Client c where c.email=:email")
	 public List<Client> findByEmail(@Param("email")String email);
	
     @Query("Select c from Client c where c.telephoneMobile=:telephone")
	 public List<Client> findByTelephoneMobile(@Param("telephone")String telephone);
     
    //Max ID from Client
     @Query("SELECT MAX(client.idclient) from Client client")
     public int maxIdClient();

}
