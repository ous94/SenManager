package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * The persistent class for the LANGUES database table.
 * 
 */
@Entity
@Table(name="LANGUES")
public class Langue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idlangue;

	@Column(name = "NOM")
	private String nom;

	//bi-directional many-to-many association to Employee
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
		name="LANGUE_EMPLOYEE"
		, joinColumns={
			@JoinColumn(name="IDLANGUE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDEMPLOYE")
			}
		)
	private List<Employee> employees;

	public Langue() {
	}
	

	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon

	@JsonCreator
	public Langue(@JsonProperty("idlangue") int idlangue,@JsonProperty("nom") String nom,@JsonProperty("employees") List<Employee> employees)
	{
		this.idlangue = idlangue;
		this.nom = nom;
		this.employees = employees;
	}

	public int getIdlangue() {
		return this.idlangue;
	}

	public void setIdlangue(int idlangue) {
		this.idlangue = idlangue;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}