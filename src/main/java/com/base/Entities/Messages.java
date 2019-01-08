package com.base.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Messages {
	private String email;
	private String message;
	private String numero;
	private String nom;
	
	public Messages()
	{
		
	}
	@JsonCreator
	public Messages(@JsonProperty("email")String email,@JsonProperty("message") String message,@JsonProperty("numero") String numero,@JsonProperty("nom") String nom)
	{
		this.email=email;
		this.message=message;
		this.numero=numero;
		this.nom=nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setNom(String nom)
	{
		this.nom=nom;
	}
	public String getNom()
	{
		return nom;
	}

}
