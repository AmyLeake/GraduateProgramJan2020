package com.mastek.catalog.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.catalog.entities.Product;

@Repository
public interface ProductJPADAO extends
				CrudRepository<Product, Integer>{

}
