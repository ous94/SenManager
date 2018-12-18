package com.base.Repository;

import org.springframework.data.repository.CrudRepository;

import com.base.Entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

}
