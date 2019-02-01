package com.base.Entities;

import java.io.Serializable;
import java.util.Date;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Contrat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idContrat;
    
	@Column(name = "DEBUT")
	@Temporal(TemporalType.DATE)
	private Date debut;

	@Column(name = "FIN")
	@Temporal(TemporalType.DATE)
	private Date fin;
	
	@Column(name = "SALAIRE")
	private int salaire;

	//bi-directional many-to-one association to Demande
	@ManyToOne
	@JoinColumn(name="idDemande")
	private Demande demande;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="idEmploye")
	private Employee employee;

	public Contrat() {
	}
	//
	@JsonCreator
	public Contrat(@JsonProperty("idContrat") int idContrat,@JsonProperty("debut") Date debut,@JsonProperty("fin") Date fin,@JsonProperty("salaire") int salaire,@JsonProperty("employee") Employee employee,@JsonProperty("demande") Demande demande) 
	{
		this.idContrat=idContrat;
		this.debut=debut;
		this.fin=fin;
		this.salaire=salaire;
		this.employee=employee;
		this.demande=demande;
	}

	public int getIdContrat() {
		return this.idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}

	public Date getDebut() {
		return this.debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public int getSalaire() {
		return this.salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	public Demande getDemande() {
		return this.demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
