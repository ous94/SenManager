package com.base.Controller;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Entities.Messages;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class MessageController {
	

	
	@PostMapping("/messages/send")
	public ResponseEntity<String> sendMessage(@RequestBody Messages messages)
	{
		try
		{
			//Definition des Proprietes du Message
			System.out.println("le message....");
			  String from = messages.getEmail();
		      String to = "koumbidia01@gmail.com";
		      String host = "localhost";
		    /*  Properties properties = System.getProperties();
		      final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		      properties.setProperty("mail.smtp.host", host);
		      properties.setProperty("mail.smtp.socketFactory.port","25");
		     // properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		     // properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		      properties.setProperty("mail.smtp.port", "25");
		     // properties.setProperty("mail.smtp.starttls.enable","true");
		      properties.setProperty("mail.transport.protocol", "smtp");*/
		     // Session session = Session.getDefaultInstance(properties);
		      Properties props = new Properties();
		      props.put("mail.smtp.auth", "false");
		      props.put("mail.smtp.host", host);
		      props.put("mail.smtp.socketFactory.port", "25");
		      props.put("mail.transport.protocol", "smtp");

		      Session session = Session.getInstance(props);
		      //Definition du Message
		      MimeMessage msg = new MimeMessage(session);
		      msg.setFrom(new InternetAddress(from));
		      msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		      msg.setSubject("Nom Client :"+messages.getNom()+" Numéro téléphone du Client : "+messages.getNumero());
		      msg.setText(messages.getMessage());
		      // Envoi du  message
		      Transport.send(msg);
		      System.out.println("le message....");
		      return new ResponseEntity<String>("1",HttpStatus.OK);
		 }
		 catch(MessagingException mex) 
		 {
			 System.out.println("hUMMMMMMMMM....");
		    mex.printStackTrace();
		    return new ResponseEntity<String>("0", HttpStatus.EXPECTATION_FAILED);
		 }
		catch(Exception e)
		{
			System.out.println("HAMMMMMMMM....");
			e.printStackTrace();
			return new ResponseEntity<String>("0", HttpStatus.EXPECTATION_FAILED);
		}
	}

}
