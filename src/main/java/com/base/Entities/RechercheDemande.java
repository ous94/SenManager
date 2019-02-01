package com.base.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RechercheDemande {
	
	private Client client;
	private int offset;
	private Demande demande;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getOffset() {
		return offset;
	}
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	@JsonCreator
	public RechercheDemande(@JsonProperty("client")Client client,@JsonProperty("offset") int offset,@JsonProperty("demande") Demande demande) {
		this.client = client;
		this.offset = offset;
		this.demande=demande;
	}

}
