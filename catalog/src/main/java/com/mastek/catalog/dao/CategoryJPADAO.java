package com.mastek.catalog.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.catalog.entities.Category;

@Repository
public interface CategoryJPADAO extends
				CrudRepository<Category, Integer>{

}
