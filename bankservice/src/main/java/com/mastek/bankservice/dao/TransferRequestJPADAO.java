package com.mastek.bankservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bankservice.entities.TransferRequest;

@Repository
public interface TransferRequestJPADAO extends
			MongoRepository<TransferRequest, Integer>{

}
