package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


/**
 * The persistent class for the CLIENTS database table.
 * 
 */
@Entity
@Table(name="CLIENTS")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idclient;

	@Column(name = "ADRESSE")
	private String adresse;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "IDENTIFICATION")
	private String identification;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "OBSERVATION")
	private String observation;

	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "SEXE")
	private String sexe;

	@Column(name="TELEPHONE_FIXE")
	private String telephoneFixe;

	@Column(name="TELEPHONE_MOBILE")
	private String telephoneMobile;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;

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

	//bi-directional many-to-one association to Demande
	@OneToMany(mappedBy="client")
	private List<Demande> demandes;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="client")
	private List<Document> documents;

	public Client() {
	}
	
	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
    @JsonCreator
    public Client(@JsonProperty("idclient") int idclient,@JsonProperty("adresse") String adresse,
    		@JsonProperty("email") String email,@JsonProperty("identification") String identification,
    		@JsonProperty("nom") String nom,@JsonProperty("observation")String observation,
    		@JsonProperty("prenom") String prenom,@JsonProperty("sexe") String sexe,
    		@JsonProperty("telephoneFixe") String telephoneFixe,@JsonProperty("telephoneMobile")String telephoneMobile,
    		@JsonProperty("pay") Pays pay,@JsonProperty("localite") Localite localite,
    		@JsonProperty("typeIdentification") TypeIdentification typeIdentification,@JsonProperty("demandes") List<Demande> demandes,
    		@JsonProperty("document") List<Document> documents,@JsonProperty("login")String login,@JsonProperty("password") String password)
    {
    	this.idclient=idclient;
    	this.adresse=adresse;
    	this.email=email;
    	this.identification=identification;
    	this.nom=nom;
    	this.observation=observation;
    	this.prenom=prenom;
    	this.sexe=sexe;
    	this.telephoneFixe=telephoneFixe;
    	this.telephoneMobile=telephoneMobile;
    	this.pay=pay;
    	this.localite=localite;
    	this.typeIdentification=typeIdentification;
    	this.demandes=demandes;
    	this.documents=documents;
    	this.login=login;
    	this.password=password;
    }
    
	public int getIdclient() {
		return this.idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTelephoneFixe() {
		return this.telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public String getTelephoneMobile() {
		return this.telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
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

	public List<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public Demande addDemande(Demande demande) {
		getDemandes().add(demande);
		demande.setClient(this);

		return demande;
	}

	public Demande removeDemande(Demande demande) {
		getDemandes().remove(demande);
		demande.setClient(null);

		return demande;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setClient(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setClient(null);

		return document;
	}

}