package com.mastek.catalog.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.catalog.entities.Customer;

@Repository
public interface CustomerJPADAO extends
		CrudRepository<Customer, Integer>{

}
