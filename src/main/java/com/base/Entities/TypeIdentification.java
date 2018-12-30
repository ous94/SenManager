package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * The persistent class for the TYPE_IDENTIFICATIONS database table.
 * 
 */
@Entity
@Table(name="TYPE_IDENTIFICATIONS")
public class TypeIdentification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ididentification;

	@Column(name = "NOM")
	private String nom;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="typeIdentification")
	private List<Client> clients;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="typeIdentification")
	private List<Employee> employees;

	public TypeIdentification() {
	}
	
	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
	@JsonCreator
	public TypeIdentification(@JsonProperty("ididentification") int ididentification,@JsonProperty("nom") String nom,
			@JsonProperty("clients") List<Client> clients,@JsonProperty("employees") List<Employee> employees)
	{
		this.ididentification = ididentification;
		this.nom = nom;
		this.clients = clients;
		this.employees = employees;
	}

	public int getIdidentification() {
		return this.ididentification;
	}

	public void setIdidentification(int ididentification) {
		this.ididentification = ididentification;
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
		client.setTypeIdentification(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setTypeIdentification(null);

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
		employee.setTypeIdentification(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setTypeIdentification(null);

		return employee;
	}

}