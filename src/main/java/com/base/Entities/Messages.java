package com.base.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="messages")
public class Messages implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private int numero;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "MESSAGE")
	private String message;
	@Column(name = "NOMCLIENT")
	private String nomClient;
	@Column(name = "TELCLIENT")
	private String telClient;
	
	public Messages()
	{
		
	}
	public String getTelClient() {
		return telClient;
	}
	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}
	@JsonCreator
	public Messages(@JsonProperty("email")String email,@JsonProperty("message") String message,@JsonProperty("numero") int numero,@JsonProperty("nomClient") String nomClient,@JsonProperty("telClient") String telClient)
	{
		this.email=email;
		this.message=message;
		this.numero=numero;
		this.nomClient=nomClient;
		this.telClient=telClient;
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setNomClient(String nomClient)
	{
		this.nomClient=nomClient;
	}
	public String getNomClient()
	{
		return nomClient;
	}

}