package com.mastek.farm2home.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.farm2home.entities.Customer;

@Repository
public interface CustomerJPADAO extends
					CrudRepository<Customer, Integer>{
	

}
