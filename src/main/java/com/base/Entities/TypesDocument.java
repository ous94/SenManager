package com.base.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * The persistent class for the TYPES_DOCUMENTS database table.
 * 
 */
@Entity
@Table(name="TYPES_DOCUMENTS")
public class TypesDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtypedocument;

	@Column(name = "NOM")
	private String nom;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="typesDocument")
	private List<Document> documents;

	public TypesDocument() {
	}
	
	//Definition du constructeur Json qui permet de construire un Objet Client a partir de Donnees de type JSon
	@JsonCreator
	public TypesDocument(@JsonProperty("idtypedocument") int idtypedocument,@JsonProperty("nom") String nom,@JsonProperty("documents") List<Document> documents)
	{
		this.idtypedocument = idtypedocument;
		this.nom = nom;
		this.documents = documents;
	}

	public int getIdtypedocument() {
		return this.idtypedocument;
	}

	public void setIdtypedocument(int idtypedocument) {
		this.idtypedocument = idtypedocument;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setTypesDocument(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setTypesDocument(null);

		return document;
	}

}