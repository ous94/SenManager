package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * The persistent class for the COMPETENCE database table.
 * 
 */
@Entity
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcompetence;

	@Column(name = "DESCRIPTION")
	private String description;

	//bi-directional many-to-many association to Demande
	@ManyToMany
	@JoinTable(
		name="COMPETENCE_DEMANDE"
		, joinColumns={
			@JoinColumn(name="IDCOMPETENCE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDDEMANDE")
			}
		)
	private List<Demande> demandes;

	//bi-directional many-to-many association to Employee
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="COMPETENCE_EMPLOYEE"
		, joinColumns={
			@JoinColumn(name="IDCOMPETENCE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDEMPLOYE")
			}
		)
	private List<Employee> employees;

	public Competence() {
	}
	
	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
    @JsonCreator
    public Competence(@JsonProperty("idcomptence") int idcompetence,@JsonProperty("description") String description,
    		@JsonProperty("demandes") List<Demande> demandes,@JsonProperty("emplotyees") List<Employee> employees)
    {
    	this.idcompetence=idcompetence;
    	this.description=description;
    	this.demandes=demandes;
    	this.employees=employees;
    }
	public int getIdcompetence() {
		return this.idcompetence;
	}

	public void setIdcompetence(int idcompetence) {
		this.idcompetence = idcompetence;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}