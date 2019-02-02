package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


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
	private String photo;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "RELIGION")
	private String religion;

	
	@Column(name="SITUATION_MATRIMONIALE")
	private String situationMatrimoniale;

	@Column(name="TELEPHONE_FIXE")
	private String telephoneFixe;

	@Column(name="TELEPHONE_MOBILE")
	private String telephoneMobile;

	//bi-directional many-to-many association to Competence
	//@ManyToMany(mappedBy="employees")
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "COMPETENCE_EMPLOYEE",
            joinColumns = { @JoinColumn(name = "IDEMPLOYE") },
            inverseJoinColumns = { @JoinColumn(name = "IDCOMPETENCE") })
	private Set<Competence> competences;

	//bi-directional many-to-many association to Demande
	//@ManyToMany(mappedBy="employees")
	@ManyToMany(fetch = FetchType.LAZY,
		    cascade = {
		        CascadeType.PERSIST
		    })
	@JoinTable(
			name="DEMANDE_EMPLOYEE"
			, joinColumns={
				@JoinColumn(name="IDEMPLOYE")
				}
			, inverseJoinColumns={
				@JoinColumn(name="IDDEMANDE")
				}
	)
	private Set<Demande> demandes;

	//bi-directional many-to-one association to Disponibilite
	@OneToMany(fetch=FetchType.LAZY,mappedBy="employee",cascade = {CascadeType.PERSIST})
	private Set<Disponibilite> disponibilites;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="employee")
	private Set<Document> documents;

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
	private Set<Experience> experiences;

	//bi-directional many-to-one association to Formation
	@OneToMany(mappedBy="employee")
	private Set<Formation> formations;

	//bi-directional many-to-many association to Langue
	//@ManyToMany(mappedBy="employees")
	@ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST
    })
    @JoinTable(name = "LANGUE_EMPLOYEE",
    joinColumns = { @JoinColumn(name = "IDEMPLOYE") },
    inverseJoinColumns = { @JoinColumn(name = "IDLANGUE") })
	private Set<Langue> langues;
	
	//bi-directional many-to-one association to Contrat
	@OneToMany(mappedBy="employee")
	private Set<Contrat> contrats;

	public Employee() {
	} 
	
	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type json
	@JsonCreator
	public Employee(@JsonProperty("idemploye") int idemploye,@JsonProperty("adresse") String adresse,@JsonProperty("dateNaissance") Date dateNaissance,
			@JsonProperty("email") String email,@JsonProperty("identification") String identification,@JsonProperty("nom") String nom,
			@JsonProperty("observation") String observation,@JsonProperty("photo")String photo,@JsonProperty("prenom") String prenom,
			@JsonProperty("religion") String religion,@JsonProperty("situationMatrimoniale") String situationMatrimoniale,
			@JsonProperty("telephoneFixe") String telephoneFixe,@JsonProperty("telephoneMobile") String telephoneMobile,
			@JsonProperty("competences") Set<Competence> competences,@JsonProperty("demandes") Set<Demande> demandes,@JsonProperty("disponibilites") Set<Disponibilite> disponibilites,
			@JsonProperty("documents") Set<Document> documents,@JsonProperty("pay") Pays pay,@JsonProperty("localite") Localite localite,
			@JsonProperty("typeIdentification") TypeIdentification typeIdentification,@JsonProperty("niveauetude") Niveauetude niveauetude,@JsonProperty("ethnies") Ethnies ethnies,
			@JsonProperty("experiences") Set<Experience> experiences,@JsonProperty("formations") Set<Formation> formations,@JsonProperty("langues") Set<Langue> langues,@JsonProperty("contrats") Set<Contrat> contrats )
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
		this.contrats=contrats;
	}

	public Set<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(Set<Contrat> contrats) {
		this.contrats = contrats;
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

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
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

	public String getTelephoneFixe() {
		return this.telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public  String getTelephoneMobile() {
		return this.telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}
	public Set<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}

	public Set<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}

	public Set<Disponibilite> getDisponibilites() {
		return this.disponibilites;
	}

	public void setDisponibilites(Set<Disponibilite> disponibilites) {
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

	public Ethnies getEthnies() {
		return ethnies;
	}

	public void setEthnies(Ethnies ethnies) {
		this.ethnies = ethnies;
	}

	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
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

	public Set<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(Set<Experience> experiences) {
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

	public Set<Formation> getFormations() {
		return this.formations;
	}

	public void setFormations(Set<Formation> formations) {
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

	public Set<Langue> getLangues() {
		return this.langues;
	}

	public void setLangues(Set<Langue> langues) {
		this.langues = langues;
	}
	
}