package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Department;

@Repository
public interface DepartmentJPADAO extends
		CrudRepository<Department, Integer>{

}
