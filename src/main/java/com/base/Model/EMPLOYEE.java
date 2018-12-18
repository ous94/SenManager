package com.base.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.base.Model.*;


@Entity
@Table(name = "EMPLOYEE")
public class EMPLOYEE  implements Serializable {
	
	@Id
	@GeneratedValue
	private int IDEMPLOYE;
	
	@ManyToOne
	@JoinColumn(name="IDPAYS")
	private PAYS pays; 
	
	@ManyToOne
	@JoinColumn(name="IDLOCALITE")
	private lOCALITES localite;
	
	@ManyToOne
	@JoinColumn(name="IDIDENTIFICATION")
	private TYPE_IDENTIFICATIONS type_IDENTIFICATIONS;
	
	@ManyToOne
	@JoinColumn(name="IDNIVEAU")
	private NIVEAUETUDES niveauetudes;
	
	@ManyToOne
	@JoinColumn(name="ETHNIES")
	private  ETHNIES ethnies;
	
	@Column(name = "NOM")
	private String NOM;
	
	@Column(name = "PRENOM")
	private String PRENOM;
	
	@Column(name = "DATE_NAISSANCE")
	private Date DATE_NAISSANCE;
	
	@Column(name = "ADRESSE")
	private String ADRESSE;
	
	
	@Column(name = "TELEPHONE")
	private Long TELEPHONE;
	
	@Column(name = "EMAIL")
	private String EMAIL;
	
	
	@Column(name = "SITUATION_PATRIMONIALE")
	private String  SITUATION_PATRIMONIALE;
	
	@Column(name = "RELIGION")
	private String RELIGION;
	
	@Column(name = "IDENTIFICATION")
	private Long IDENTIFICATION;
	
	@Column(name = "PHOTO")
	private byte[] PHOTO;
	
	@Column(name = "OBSERVATION")
	private String OBSERVATION;
	
	
	@OneToMany(mappedBy="EMPLOYEE",fetch=FetchType.LAZY)
	private Collection<DISPONIBILITE> disponibilites ;
	
	@OneToMany(mappedBy="EMPLOYEE",fetch=FetchType.LAZY)
	private Collection<EXPERIENCE> experiences ;
	
	@OneToMany(mappedBy="EMPLOYEE",fetch=FetchType.LAZY)
	private Collection<FORMATION> formationS ;
	
	
	@OneToMany(mappedBy="EMPLOYEE",fetch=FetchType.LAZY)
	private Collection<DOCUMENTS> documents ;
	
	
	

}
