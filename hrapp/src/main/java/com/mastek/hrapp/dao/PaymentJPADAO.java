package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.mastek.hrapp.entities.Payment;

public interface PaymentJPADAO extends
				CrudRepository<Payment, Integer>{

}
