package com.base.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Repository.DisponibiliteRepository;
import com.base.Entities.Disponibilite;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class DisponibiliteController {
	
	@Autowired
	DisponibiliteRepository disponibiliteRepository;

}
