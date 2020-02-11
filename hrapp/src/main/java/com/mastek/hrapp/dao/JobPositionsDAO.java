package com.mastek.hrapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.JobPositions;

@Repository //mark the class as repository
public interface JobPositionsDAO extends 
		MongoRepository<JobPositions, Integer>{
		// map the document and identifier type with MongoRepository.
}
