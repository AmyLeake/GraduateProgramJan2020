package com.mastek.farm2home.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.farm2home.entities.Farmer;

@Repository
public interface FarmerJPADAO extends
					CrudRepository<Farmer, Integer>{

}
