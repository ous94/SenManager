package com.base.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RechercheTous {
	String recherche;
    int offset;
    @JsonCreator
	public RechercheTous(@JsonProperty("recherche")String recherche,@JsonProperty("offset") int offset) {
		this.recherche = recherche;
		this.offset = offset;
	}
	public String getRecherche() {
		return recherche;
	}
	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
    
}
