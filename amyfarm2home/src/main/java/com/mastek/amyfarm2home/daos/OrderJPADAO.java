package com.mastek.amyfarm2home.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.amyfarm2home.entities.Order;

@Repository
public interface OrderJPADAO extends 
					CrudRepository<Order, Integer>{

}
