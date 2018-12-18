package com.base.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CLIENTS implements Serializable {
	
	@Id
	private  long IDCLIENT;
	
	@ManyToOne
	@JoinColumn(name="IDPAYS")
	private PAYS pays; 
	
	@ManyToOne
	@JoinColumn(name="IDLOCALITE")
	private lOCALITES localite;
	
	@ManyToOne
	@JoinColumn(name="IDIDENTIFICATION")
	private TYPE_IDENTIFICATIONS type_IDENTIFICATIONS;
	
	
	
	@Column(name = "NOM")
	private String NOM;
	
	@Column(name = "PRENOM")
	private String PRENOM;
	
	
	@Column(name = "TELEPHONE")
	private Long TELEPHONE;
	
	@Column(name = "ADRESSE")
	private String ADRESSE;
	
	
	@Column(name = "EMAIL")
	private String EMAIL;
	
	@Column(name = "SEXE")
	private String SEXE;
	
	@Column(name = "IDENTIFICATION")
	private Long IDENTIFICATION;
	
	
	@Column(name = "OBSERVATION")
	private String OBSERVATION;
	

}
