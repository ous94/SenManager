package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PAYS database table.
 * 
 */
@Entity
@Table(name="PAYS")
public class Pays implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpays;

	private String nom;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="pay")
	private List<Client> clients;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="pay")
	private List<Employee> employees;

	public Pays() {
	}

	public int getIdpays() {
		return this.idpays;
	}

	public void setIdpays(int idpays) {
		this.idpays = idpays;
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
		client.setPay(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setPay(null);

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
		employee.setPay(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setPay(null);

		return employee;
	}

}