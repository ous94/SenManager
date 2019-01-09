package com.base.Controller;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Entities.Messages;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class MessageController {
	
	@PostMapping("/message/send")
	public ResponseEntity<String> sendMessage(@PathVariable("message") Messages message)
	{
		try
		{
			//Definition des Proprietes du Message
			  String from = message.getEmail();
		      String to = "adrienniokhorsene@gmail.com";
		      String host = "localhost";
		      Properties properties = System.getProperties();
		      properties.setProperty("mail.smtp.host", host);
		      Session session = Session.getDefaultInstance(properties);
		      //Definition du Message
		      MimeMessage msg = new MimeMessage(session);
		      msg.setFrom(new InternetAddress(from));
		      msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		      msg.setSubject("Nom Client :"+message.getNom()+" Numéro téléphone du Client : "+message.getNumero());
		      msg.setText(message.getMessage());
		      // Envoi du  message
		      Transport.send(msg);
		      System.out.println("le messaage....");
		      return new ResponseEntity<String>("1",HttpStatus.OK);
		 }
		 catch(MessagingException mex) 
		 {
		    mex.printStackTrace();
		    return new ResponseEntity<String>("0", HttpStatus.EXPECTATION_FAILED);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("0", HttpStatus.EXPECTATION_FAILED);
		}
	}

}
