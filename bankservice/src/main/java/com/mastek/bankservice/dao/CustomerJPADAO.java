package com.mastek.bankservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bankservice.entities.Customer;

@Repository
public interface CustomerJPADAO extends
				CrudRepository<Customer, Integer>{

}
