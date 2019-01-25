package com.base.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RechercheCompetence {
	private  List<Competence>listeCompetences;
    private int offset;
	public List<Competence> getListeCompetences() {
		return listeCompetences;
	}
	public void setListeCompetences(List<Competence> listeCompetences) {
		this.listeCompetences = listeCompetences;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	@JsonCreator
	public RechercheCompetence(@JsonProperty("listeCompetences")List<Competence> listeCompetences,@JsonProperty("offset") int offset) {
		this.listeCompetences = listeCompetences;
		this.offset = offset;
	}  

}
