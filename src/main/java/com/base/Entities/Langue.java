package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;
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
	@ManyToMany
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