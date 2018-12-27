package com.base.Storage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
 
@Service
public class StorageService {
 
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("./upload-dir");
 
	public void store(MultipartFile file,String nomFichier) {
		
		try {
			String nom;
			nom=file.getContentType();
			System.out.println("Chemin courant :"+System.getProperty("user.dir")) ;
			Files.copy(file.getInputStream(),this.rootLocation.resolve(nomFichier));
			System.out.println("Enregistrement du fichier reussie et son nom sur  le poste client est :"+nom);
		} catch (Exception e) {
			System.out.println("Hum Echec Echec !!!!!!!!!!!!!");
			 e.printStackTrace();
		}
	}
 
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				System.out.println("Fichier trouver");
				return resource;
			} else {
				System.out.println("Hum le Fichier que vous demandez est introuvable");
				return null;
			}
		} catch (MalformedURLException e) {
			System.out.println("Ficher introuvable");
			e.printStackTrace();
			return null;
		}
	}
 
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
 
	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}
