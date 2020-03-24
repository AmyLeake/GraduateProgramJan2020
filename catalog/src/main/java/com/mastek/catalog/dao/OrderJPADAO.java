package com.mastek.catalog.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.catalog.entities.Order;

@Repository
public interface OrderJPADAO extends 
				CrudRepository<Order, Integer>{

}
