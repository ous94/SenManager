package com.base.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.base.Entities.TypeIdentification;

public interface TypeIdentificationRepository extends CrudRepository<TypeIdentification,Integer> {
	
	List<TypeIdentification> findByNom(String nom);
	@Query("SELECT t FROM TypeIdentification t where t.nom like %:nom% order by t.ididentification ASC")
	List<TypeIdentification>findByNomPagination(@Param("nom") String nom,Pageable pageable);
	@Query("SELECT t from TypeIdentification t  order by  t.ididentification ASC")
	List<TypeIdentification> mestypes(Pageable  pageable);

}
