package com.base.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Repository.NiveauEtudeRepository;
import com.base.Entities.Niveauetude;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class NiveauEtudeController {
	
	@Autowired
	NiveauEtudeRepository niveauEtudeRepository;

}
