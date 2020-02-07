package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Project;

@Repository
public interface ProjectJPADAO extends
			CrudRepository<Project, Integer>{

}
