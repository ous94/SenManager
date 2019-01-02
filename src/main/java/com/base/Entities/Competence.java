package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;


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
	/*@ManyToMany
	@JoinTable(
		name="COMPETENCE_DEMANDE"
		, joinColumns={
			@JoinColumn(name="IDCOMPETENCE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDDEMANDE")
			}
		)
	*/
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
	                CascadeType.MERGE
	            })
	@JoinTable(
			name="COMPETENCE_DEMANDE"
			, joinColumns={
				@JoinColumn(name="IDCOMPETENCE")
				}
			, inverseJoinColumns={
				@JoinColumn(name="IDDEMANDE")
				}
			)
	private Set<Demande> demandes;

	//bi-directional many-to-many association to Employee
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="COMPETENCE_EMPLOYEE"
		, joinColumns={
			@JoinColumn(name="IDCOMPETENCE")
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
	@JoinTable(name = "COMPETENCE_EMPLOYEE",
    joinColumns = { @JoinColumn(name = "IDCOMPETENCE") },
    inverseJoinColumns = { @JoinColumn(name = "IDEMPLOYE") })
	private Set<Employee> employees;

	public Competence() {
	}
	
	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
    @JsonCreator
    public Competence(@JsonProperty("idcompetence") int idcompetence,@JsonProperty("description") String description,
    		@JsonProperty("demandes") Set<Demande> demandes,@JsonProperty("employees") Set<Employee> employees)
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

	public Set<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}