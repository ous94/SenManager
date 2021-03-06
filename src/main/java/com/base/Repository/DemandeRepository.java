package com.base.Repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Client;
import com.base.Entities.Contrat;
import com.base.Entities.Demande;

public interface DemandeRepository extends CrudRepository<Demande,Integer>{
	
	public List<Demande> findByServices(String services);
	public List<Demande> findByDate(Date date);
	public List<Demande> findBySalairePropose(int salairePropose);
	public List<Demande> findBySalaireRetenue(int salaireRetenue);
	@Query("SELECT demande from Demande demande where demande.client=:client order by demande.date DESC")
	public List<Demande> findByClientPagination(@Param("client")Client client,Pageable pageable);
	@Query("SELECT demande from Demande demande order by demande.date DESC")
	public List<Demande>allDemandePagination(Pageable pageable);
	
	//Liste contrats d'un Client
	@Query("SELECT demande.contrats from Demande demande where demande.client=:client order by demande.date DESC")
	public List<Contrat> contratClientPagination(@Param("client")Client client);
	
	@Query("SELECT demande from Demande demande, Client client where demande.date like :date or demande.salairePropose like :salairePropose or demande.services like %:services% "
			+ " or (client.nom like :nom and client.prenom like :prenom ) and demande.client=client order by demande.date DESC")
	public List<Demande> rechercheDemandeDetails(@Param("nom") String nom,@Param("prenom")String prenom,@Param("date") Date date, @Param("salairePropose") int salairePropose ,@Param("services")String services,Pageable pageable);
	
    @Query("SELECT COUNT(demande.iddemande) from Demande demande where demande.client=:client")
    public int countDemandeClient(@Param("client") Client client);
    
    @Query("SELECT count(contrat.idContrat) from Contrat contrat where contrat.demande in "
    		+ "(select demande from Demande demande where demande.client=:client)")
	public int countContratClient(@Param("client")Client client);
	
    //Max IdDemande from Demande
    @Query("SELECT MAX(demande.iddemande) from Demande demande")
    public String maxIdDemande();
}
