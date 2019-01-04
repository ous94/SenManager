package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the DISPONIBILITE database table.
 * 
 */
@Entity
public class Disponibilite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int iddisponibilite;

	@Column(name = "OBSERVATION")
	private String observation;
	@Column(name = "horaire")
	private String horaire;
	@Column(name = "moment")
	private String moment;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDEMPLOYE")
	private Employee employee;
	public Disponibilite() {
	}

	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
	@JsonCreator
	public Disponibilite(@JsonProperty("iddisponibilite") int iddisponibilite,@JsonProperty("observation") String observation,
			             @JsonProperty("employee") Employee employee,@JsonProperty("horaire") String horaire,@JsonProperty("moment") String moment)
	{
		this.iddisponibilite=iddisponibilite;
		this.observation=observation;
		this.employee=employee;
		this.moment=moment;
		this.horaire=horaire;
	}
	
	public String getHoraire() {
		return this.horaire;
	}

	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	public String getMoment() {
		return this.moment;
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public int getIddisponibilite() {
		return this.iddisponibilite;
	}

	public void setIddisponibilite(int iddisponibilite) {
		this.iddisponibilite = iddisponibilite;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}