package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the DEMANDE database table.
 * 
 */
@Entity
public class Demande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int iddemande;
	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="SALAIRE_PROPOSE")
	private int salairePropose;

	@Column(name="SALAIRE_RETENUE")
	private int salaireRetenue;

	@Column(name = "SERVICES")
	private String services;

	//bi-directional many-to-many association to Competence
	//@ManyToMany(mappedBy="demandes")
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="COMPETENCE_DEMANDE"
			, joinColumns={
				@JoinColumn(name="IDDEMANDE")
				}
			, inverseJoinColumns={
				@JoinColumn(name="IDCOMPETENCE")
				}
	)
	private Set<Competence> competences;


	//bi-directional many-to-one association to Client
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCLIENT")
	private Client client;

	//bi-directional many-to-many association to Employee
	/*@ManyToMany
	@JoinTable(
		name="DEMANDE_EMPLOYEE"
		, joinColumns={
			@JoinColumn(name="IDDEMANDE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDEMPLOYE")
			}
		)
	*/
	@ManyToMany(fetch = FetchType.LAZY,
		    cascade = {
		        CascadeType.MERGE
		    })
	@JoinTable(
			name="DEMANDE_EMPLOYEE"
			, joinColumns={
				@JoinColumn(name="IDDEMANDE")
				}
			, inverseJoinColumns={
				@JoinColumn(name="IDEMPLOYE")
				}
	)
	private Set<Employee> employees;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="demande")
	private Set<Document> documents;
	
	//bi-directional many-to-one association to Contrat
	@OneToMany(mappedBy="demande")
	private Set<Contrat> contrats;

	public Demande() {
	}

	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
	@JsonCreator
	public Demande(@JsonProperty("iddemande") int iddemande,@JsonProperty("date")Date date,@JsonProperty("salairePropose") int salairePropose,
			@JsonProperty("salaireRetenue") int salaireRetenue,@JsonProperty("services") String services,@JsonProperty("competences") Set<Competence> competences,
			@JsonProperty("client") Client client,@JsonProperty("employees") Set<Employee> employees,
			@JsonProperty("documents") Set<Document> documents,@JsonProperty("contrats") Set<Contrat> contrats )
	{
		this.iddemande=iddemande;
		this.date=date;
		this.salairePropose=salairePropose;
		this.salaireRetenue=salaireRetenue;
		this.services=services;
		this.competences=competences;
		this.client=client;
		this.employees=employees;
		this.documents=documents;
		this.contrats=contrats;
	}
	public int getIddemande() {
		return this.iddemande;
	}

	public void setIddemande(int iddemande) {
		this.iddemande = iddemande;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSalairePropose() {
		return this.salairePropose;
	}

	public void setSalairePropose(int salairePropose) {
		this.salairePropose = salairePropose;
	}

	public int getSalaireRetenue() {
		return this.salaireRetenue;
	}

	public void setSalaireRetenue(int salaireRetenue) {
		this.salaireRetenue = salaireRetenue;
	}

	public String getServices() {
		return this.services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public Set<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	public Set<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(Set<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setDemande(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setDemande(null);

		return document;
	}

}