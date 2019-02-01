package com.base.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RechercheContrat {
	
	private Employee employe;
	private Demande demande;
	private int offset;
	private Client client;
	private Contrat contrat;
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employee getEmploye() {
		return employe;
	}
	public void setEmploye(Employee employe) {
		this.employe = employe;
	}
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	@JsonCreator
	public RechercheContrat(@JsonProperty("employe") Employee employe,@JsonProperty("demande") Demande demande,@JsonProperty("offset") int offset,@JsonProperty("client") Client client ,@JsonProperty("contrat") Contrat contrat) {
		super();
		this.employe = employe;
		this.demande = demande;
		this.offset = offset;
		this.client=client;
		this.contrat=contrat;
	}

}
