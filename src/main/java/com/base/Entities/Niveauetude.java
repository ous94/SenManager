package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * The persistent class for the NIVEAUETUDES database table.
 * 
 */
@Entity
@Table(name="NIVEAUETUDES")
public class Niveauetude implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idniveau;

	@Column(name = "NIVEAU")
	private String niveau;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="niveauetude")
	private List<Employee> employees;

	public Niveauetude() {
	}
	
	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
	@JsonCreator
	public Niveauetude(@JsonProperty("idniveau") int idniveau,@JsonProperty("niveau") String niveau,@JsonProperty("employees") List<Employee> employees)
	{
		this.idniveau = idniveau;
		this.niveau = niveau;
		this.employees = employees;
	}

	public int getIdniveau() {
		return this.idniveau;
	}

	public void setIdniveau(int idniveau) {
		this.idniveau = idniveau;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setNiveauetude(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setNiveauetude(null);

		return employee;
	}

}