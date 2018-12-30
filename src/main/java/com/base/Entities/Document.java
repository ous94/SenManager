package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the DOCUMENTS database table.
 * 
 */
@Entity
@Table(name="DOCUMENTS")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int iddocument;

	@Column(name = "CHEMIN")
	private String chemin;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCLIENT")
	private Client client;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDEMPLOYE")
	private Employee employee;

	//bi-directional many-to-one association to Demande
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDDEMANDE")
	private Demande demande;

	//bi-directional many-to-one association to TypesDocument
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDTYPEDOCUMENT")
	private TypesDocument typesDocument;

	public Document() {
	}

	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
	@JsonCreator
	public Document(@JsonProperty("iddocument") int iddocument,@JsonProperty("chemin")String chemin,@JsonProperty("client") Client client,
			@JsonProperty("employee") Employee employee,@JsonProperty("demande") Demande demande,@JsonProperty("typesDocument") TypesDocument typesDocument)
	{
		this.iddocument=iddocument;
		this.chemin=chemin;
		this.employee=employee;
		this.demande=demande;
		this.typesDocument=typesDocument;
	}
	
	public int getIddocument() {
		return this.iddocument;
	}

	public void setIddocument(int iddocument) {
		this.iddocument = iddocument;
	}

	public String getChemin() {
		return this.chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Demande getDemande() {
		return this.demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public TypesDocument getTypesDocument() {
		return this.typesDocument;
	}

	public void setTypesDocument(TypesDocument typesDocument) {
		this.typesDocument = typesDocument;
	}

}