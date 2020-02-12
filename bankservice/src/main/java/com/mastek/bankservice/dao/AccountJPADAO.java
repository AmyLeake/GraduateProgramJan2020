package com.mastek.bankservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bankservice.entities.Account;

@Repository
public interface AccountJPADAO extends
			CrudRepository<Account, Integer>{

}
