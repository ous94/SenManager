package com.base.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

/*
	  try {
		            String sql = "SELECT p from Employee p where p.situation_Matrimoniale="+;
		            Query query = entityManager.createQuery(sql);
		            return (Long) query.getSingleResult();
		        } catch (NoResultException e) {
		            return 0L;
		        }
		    }*/
	//List<Employee> findbySituation(String genre);
	// JPA
	//@Query("SELECT p from Employee p where p.situation_Matrimoniale:situation_Matrimoniale")
	//public Employee maRequêteAvecQueryDeRecher(@Param("situation_Matrimoniale") String situation_Matrimoniale);
	
	@Query(value= "select p.prenom from Employee p where p.SITUATION_MATRIMONIALE=?1",nativeQuery=true)
    List<Employee> findByNameEndsWith(String chars);
	
	//@Query("select u from Employee u where u.prenom = :prenom or u.nom = :nom") 
	//Employee findByLastnameOrFirstname(@Param("prenom") String prenom, @Param("nom") String nom);
	
	//@Query("select nom,prenom from Employee u where u.adresse = :adresse") 
	//String[]  findByAdresse(@Param("adresse") String adresse);
	
	
	//@Query("select nom,prenom,situation_matrimoniale from Employee u where u.adresse = :adresse") 
	 //String[] findByAdresse(@Param("adresse") String adresse);
	
	
	
	
	

}
