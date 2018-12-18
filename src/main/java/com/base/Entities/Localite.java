package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOCALITES database table.
 * 
 */
@Entity
@Table(name="LOCALITES")
public class Localite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idlocalite;

	@Column(name = "NOM")
	private String nom;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="localite")
	private List<Client> clients;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="localite")
	private List<Employee> employees;

	public Localite() {
	}

	public int getIdlocalite() {
		return this.idlocalite;
	}

	public void setIdlocalite(int idlocalite) {
		this.idlocalite = idlocalite;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setLocalite(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setLocalite(null);

		return client;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setLocalite(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setLocalite(null);

		return employee;
	}

}