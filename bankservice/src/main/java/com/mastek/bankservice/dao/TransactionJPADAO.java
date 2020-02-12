package com.mastek.bankservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bankservice.entities.Transaction;

@Repository
public interface TransactionJPADAO extends
				CrudRepository<Transaction, Integer>{

}
