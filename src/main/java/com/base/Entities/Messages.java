package com.base.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public Messages(String email, String message, String nomClient, String telClient, Date date) {
		super();
		this.email = email;
		this.message = message;
		this.nomClient = nomClient;
		this.telClient = telClient;
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
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
	public Messages(@JsonProperty("email")String email,@JsonProperty("message") String message,@JsonProperty("numero") int numero,@JsonProperty("nomClient") String nomClient,@JsonProperty("telClient") String telClient,@JsonProperty("date")Date date)
	{
		this.email=email;
		this.message=message;
		this.numero=numero;
		this.nomClient=nomClient;
		this.telClient=telClient;
		this.date=date;
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