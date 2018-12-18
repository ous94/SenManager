package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
	@ManyToMany(mappedBy="demandes")
	private List<Competence> competences;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCLIENT")
	private Client client;

	//bi-directional many-to-many association to Employee
	@ManyToMany
	@JoinTable(
		name="DEMANDE_EMPLOYEE"
		, joinColumns={
			@JoinColumn(name="IDDEMANDE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDEMPLOYE")
			}
		)
	private List<Employee> employees;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="demande")
	private List<Document> documents;

	public Demande() {
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

	public List<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
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