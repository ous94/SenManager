package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * The persistent class for the FORMATION database table.
 * 
 */
@Entity
public class Formation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idformation;

	@Temporal(TemporalType.DATE)
	@Column(name = "ANNEE")
	private Date annee;

	@Column(name = "DIPLOME")
	private String diplome;

	@Column(name = "DUREE")
	private String duree;

	@Column(name = "NOM")
	private String nom;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDEMPLOYE")
	private Employee employee;

	public Formation() {
	}
	
	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
	@JsonCreator
	public Formation(@JsonProperty("idformation") int idformation ,@JsonProperty("annee") Date annee,@JsonProperty("diplome") String diplome,
			@JsonProperty("duree") String duree,@JsonProperty("nom") String nom,@JsonProperty("employee") Employee employee)
	{
		
		this.idformation = idformation;
		this.annee = annee;
		this.diplome = diplome;
		this.duree = duree;
		this.nom = nom;
		this.employee = employee;
	}

	public int getIdformation() {
		return this.idformation;
	}

	public void setIdformation(int idformation) {
		this.idformation = idformation;
	}

	public Date getAnnee() {
		return this.annee;
	}

	public void setAnnee(Date annee) {
		this.annee = annee;
	}

	public String getDiplome() {
		return this.diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getDuree() {
		return this.duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}