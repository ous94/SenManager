package com.base;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SenManagerApplication {

	public static void main(String[] args) {
		
		//Creation du dossier qui contiendra les photos des utilisateurs s'il n'existe pas
		File file=new File("./photos-utilisateurs");
		if(!file.exists())
		{
			boolean rep=file.mkdir();
			if(rep)
				System.out.println("Creation du dossier photos-utilisateur reussi");
		}
		SpringApplication.run(SenManagerApplication.class, args);
	}

}

