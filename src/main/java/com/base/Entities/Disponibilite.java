package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;


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

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDEMPLOYE")
	private Employee employee;

	public Disponibilite() {
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