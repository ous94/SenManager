package com.base.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Entities.TypesDocument;
import com.base.Repository.TypesDocumentRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class TypesDocumentController {
	
	@Autowired
	TypesDocumentRepository typesDocumentRepository;
	
	@GetMapping("/typeDocuments/nom/{nom}")
	public List<String> getAllnomTyepDocuments(@PathVariable("nom") String nom) {
		try
		{
		   System.out.println("Get all TypeDocumemts.nom...");
		   List<TypesDocument> listeTyepDocuments = new ArrayList<>();
		   typesDocumentRepository.findByNom(nom).forEach(listeTyepDocuments::add);
		   List<String> nomtypeDocumemts = new ArrayList<>();
		   Iterator<TypesDocument> it= listeTyepDocuments.iterator();
		   while(it.hasNext())
		   {
			   nomtypeDocumemts.add(it.next().getNom());
			   
			   
		   }
		   return nomtypeDocumemts;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@GetMapping("/typesdocuments/nom")
	public List<String> getAllnomLangue() {
		try
		{
		   System.out.println("...");
		   List<TypesDocument> listetypesDocument = new ArrayList<>();
		   typesDocumentRepository.findAll().forEach(listetypesDocument::add);
		   List<String> nomTypesDocument = new ArrayList<>();
		   Iterator<TypesDocument> it= listetypesDocument.iterator();
		   while(it.hasNext())
		   {
			   nomTypesDocument.add(it.next().getNom());
			   
			   
		   }
		   return nomTypesDocument;
		}
		catch(Exception e)
		{
			return null;
		}
	}


}
