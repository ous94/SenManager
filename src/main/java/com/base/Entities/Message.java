package com.base.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	private String email;
	private String message;
	private String numero;
	
	public Message()
	{
		
	}
	@JsonCreator
	public Message(@JsonProperty("email")String email,@JsonProperty("message") String message,@JsonProperty("numero") String numero)
	{
		this.email=email;
		this.message=message;
		this.numero=numero;
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

}
