package com.base.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Competence;
import com.base.Entities.Employee;

public interface ComptenceRepository extends CrudRepository<Competence ,Integer> {

	public List<Competence> findByDescription(String description);
	@Query("SELECT c FROM Competence c where c.description like %:description% ORDER BY c.idcompetence ASC")
	public List<Competence> findByDescriptionPagination(@Param("description")String description,Pageable pageable);
<<<<<<< HEAD
	@Query("Select c from Competence c ")
	List<Competence> mesCompetence(Pageable pageable);
	
=======
	@Query("SELECT c.employees FROM Competence c where c.description in :listeCompetenceDescription")
	List<Employee>rechercheEmployeeCompetenceDescription(@Param("listeCompetenceDescription") List<String> listeCompetenceDescription,Pageable pageable);
>>>>>>> 1ca43ea6be030601ab85634b98e9120cc4e0a3c8

}
