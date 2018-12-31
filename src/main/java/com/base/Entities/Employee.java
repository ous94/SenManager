package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idemploye;

	@Column(name = "ADRESSE")
	private String adresse;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_NAISSANCE")
	private Date dateNaissance;
	
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "IDENTIFICATION")
	private String identification;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "OBSERVATION")
	private String observation;

	@Column(name = "PHOTO")
	private byte[] photo;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "RELIGION")
	private String religion;

	
	@Column(name="SITUATION_MATRIMONIALE")
	private String situationMatrimoniale;

	@Column(name="TELEPHONE_FIXE")
	private BigDecimal telephoneFixe;

	@Column(name="TELEPHONE_MOBILE")
	private BigDecimal telephoneMobile;

	//bi-directional many-to-many association to Competence
	@ManyToMany(mappedBy="employees")
	private List<Competence> competences;

	//bi-directional many-to-many association to Demande
	@ManyToMany(mappedBy="employees")
	private List<Demande> demandes;

	//bi-directional many-to-one association to Disponibilite
	@OneToMany(mappedBy="employee")
	private List<Disponibilite> disponibilites;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="employee")
	private List<Document> documents;

	//bi-directional many-to-one association to Pay
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPAYS")
	private Pays pay;

	//bi-directional many-to-one association to Localite
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDLOCALITE")
	private Localite localite;

	//bi-directional many-to-one association to TypeIdentification
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDIDENTIFICATION")
	private TypeIdentification typeIdentification;

	//bi-directional many-to-one association to Niveauetude
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDNIVEAU")
	private Niveauetude niveauetude;

	//bi-directional many-to-one association to Ethny
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDETHNIES")
	private Ethnies ethnies;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="employee")
	private List<Experience> experiences;

	//bi-directional many-to-one association to Formation
	@OneToMany(mappedBy="employee")
	private List<Formation> formations;

	//bi-directional many-to-many association to Langue
	@ManyToMany(mappedBy="employees")
	private List<Langue> langues;

	public Employee() {
	}
	
	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
	@JsonCreator
	public Employee(@JsonProperty("idemploye") int idemploye,@JsonProperty("adresse") String adresse,@JsonProperty("dateNaissance") Date dateNaissance,
			@JsonProperty("email") String email,@JsonProperty("identification") String identification,@JsonProperty("nom") String nom,
			@JsonProperty("observation") String observation,@JsonProperty("photo") byte[] photo,@JsonProperty("prenom") String prenom,
			@JsonProperty("religion") String religion,@JsonProperty("situationMatrimoniale") String situationMatrimoniale,
			@JsonProperty("telephoneFixe") BigDecimal telephoneFixe,@JsonProperty("telephoneMobile") BigDecimal telephoneMobile,
			@JsonProperty("competences") List<Competence> competences,@JsonProperty("demandes") List<Demande> demandes,@JsonProperty("disponibilites") List<Disponibilite> disponibilites,
			@JsonProperty("documents") List<Document> documents,@JsonProperty("pay") Pays pay,@JsonProperty("localite") Localite localite,
			@JsonProperty("typeIdentification") TypeIdentification typeIdentification,@JsonProperty("niveauetude") Niveauetude niveauetude,@JsonProperty("ethnies") Ethnies ethnies,
			@JsonProperty("experiences") List<Experience> experiences,@JsonProperty("formations") List<Formation> formations,@JsonProperty("langues") List<Langue> langues)
	{
		this.idemploye = idemploye;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.identification = identification;
		this.nom = nom;
		this.observation = observation;
		this.photo = photo;
		this.prenom = prenom;
		this.religion = religion;
		this.situationMatrimoniale = situationMatrimoniale;
		this.telephoneFixe = telephoneFixe;
		this.telephoneMobile = telephoneMobile;
		this.competences = competences;
		this.demandes = demandes;
		this.disponibilites = disponibilites;
		this.documents = documents;
		this.pay = pay;
		this.localite = localite;
		this.typeIdentification = typeIdentification;
		this.niveauetude = niveauetude;
		this.ethnies = ethnies;
		this.experiences = experiences;
		this.formations = formations;
		this.langues = langues;
	}

	public int getIdemploye() {
		return this.idemploye;
	}

	public void setIdemploye(int idemploye) {
		this.idemploye = idemploye;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentification() {
		return this.identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getSituationMatrimoniale() {
		return this.situationMatrimoniale;
	}

	public void setSituationMatrimoniale(String situationMatrimoniale) {
		this.situationMatrimoniale = situationMatrimoniale;
	}

	public BigDecimal getTelephoneFixe() {
		return this.telephoneFixe;
	}

	public void setTelephoneFixe(BigDecimal telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public BigDecimal getTelephoneMobile() {
		return this.telephoneMobile;
	}

	public void setTelephoneMobile(BigDecimal telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public List<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public List<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public List<Disponibilite> getDisponibilites() {
		return this.disponibilites;
	}

	public void setDisponibilites(List<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}

	public Disponibilite addDisponibilite(Disponibilite disponibilite) {
		getDisponibilites().add(disponibilite);
		disponibilite.setEmployee(this);

		return disponibilite;
	}

	public Disponibilite removeDisponibilite(Disponibilite disponibilite) {
		getDisponibilites().remove(disponibilite);
		disponibilite.setEmployee(null);

		return disponibilite;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setEmployee(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setEmployee(null);

		return document;
	}

	public Pays getPay() {
		return this.pay;
	}

	public void setPay(Pays pay) {
		this.pay = pay;
	}

	public Localite getLocalite() {
		return this.localite;
	}

	public void setLocalite(Localite localite) {
		this.localite = localite;
	}

	public TypeIdentification getTypeIdentification() {
		return this.typeIdentification;
	}

	public void setTypeIdentification(TypeIdentification typeIdentification) {
		this.typeIdentification = typeIdentification;
	}

	public Niveauetude getNiveauetude() {
		return this.niveauetude;
	}

	public void setNiveauetude(Niveauetude niveauetude) {
		this.niveauetude = niveauetude;
	}

	public Ethnies getEthny() {
		return this.ethnies;
	}

	public void setEthny(Ethnies ethny) {
		this.ethnies = ethny;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setEmployee(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setEmployee(null);

		return experience;
	}

	public List<Formation> getFormations() {
		return this.formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Formation addFormation(Formation formation) {
		getFormations().add(formation);
		formation.setEmployee(this);

		return formation;
	}

	public Formation removeFormation(Formation formation) {
		getFormations().remove(formation);
		formation.setEmployee(null);

		return formation;
	}

	public List<Langue> getLangues() {
		return this.langues;
	}

	public void setLangues(List<Langue> langues) {
		this.langues = langues;
	}

}