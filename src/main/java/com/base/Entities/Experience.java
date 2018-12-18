package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EXPERIENCE database table.
 * 
 */
@Entity
public class Experience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idexperiance;

	@Column(name = "COMMENTAIRE")
	private String commentaire;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDEMPLOYE")
	private Employee employee;

	public Experience() {
	}

	public int getIdexperiance() {
		return this.idexperiance;
	}

	public void setIdexperiance(int idexperiance) {
		this.idexperiance = idexperiance;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}