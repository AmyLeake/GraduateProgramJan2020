package com.mastek.catalog.dao;

import org.springframework.data.repository.CrudRepository;

import com.mastek.catalog.entities.Order;

public interface OrderJPADAO extends 
				CrudRepository<Order, Integer>{

}
