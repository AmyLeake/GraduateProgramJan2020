package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;

@Repository //Declare the DAO layer as repository to manage Data opeations.
public interface EmployeeJPADAO extends 
			CrudRepository<Employee, Integer>{ //CrudRepository<Class, Primary Key Type>

	Iterable<Employee> findBySalary(
			@Param("minSalary")double minSalary, 
			@Param("maxSalary")double maxSalary);//<class, PK type>
	
	
	Iterable<Employee> findByDesignation(@Param("designation")Designation designation);
	
}
