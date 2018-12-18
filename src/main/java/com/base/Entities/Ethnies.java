package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ETHNIES database table.
 * 
 */
@Entity
@Table(name="ETHNIES")
public class Ethnies implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idethnies;
	@Column(name = "NOM")
	private String nom;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="ethnies")
	private List<Employee> employees;

	public Ethnies() {
	}

	public int getIdethnies() {
		return this.idethnies;
	}

	public void setIdethnies(int idethnies) {
		this.idethnies = idethnies;
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

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setEthny(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setEthny(null);

		return employee;
	}

}