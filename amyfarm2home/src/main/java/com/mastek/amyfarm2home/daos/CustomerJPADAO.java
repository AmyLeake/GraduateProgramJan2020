package com.mastek.amyfarm2home.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.amyfarm2home.entities.Customer;

@Repository
public interface CustomerJPADAO extends
					CrudRepository<Customer, Integer>{
	

}
