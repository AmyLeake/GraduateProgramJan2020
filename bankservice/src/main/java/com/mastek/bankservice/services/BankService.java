package com.mastek.bankservice.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.bankservice.dao.AccountJPADAO;
import com.mastek.bankservice.dao.CustomerJPADAO;
import com.mastek.bankservice.dao.TransactionJPADAO;
import com.mastek.bankservice.entities.Account;
import com.mastek.bankservice.entities.Customer;
import com.mastek.bankservice.entities.Transaction;

@Component
@Scope("singleton")
public class BankService {
	
	//Declaring DAO's
	@Autowired
	AccountJPADAO accDAO;
	
	@Autowired
	CustomerJPADAO custDAO;
	
	@Autowired
	TransactionJPADAO transDAO;
	
	
	public BankService() {
		System.out.println("Bank Service Created");
	}
	
	@PostConstruct
	public void initialService() {
		System.out.println("Bank Service Initialised");
	}
	
	@PreDestroy
	public void terminateService() {
		System.out.println("Bank Service Terminated");
	}
	
	//Associating Account and Transaction (one to many)
	@Transactional
	public Transaction assignTransactionToAccount(int transaction_id, int account_number) {
		Transaction trans = transDAO.findById(transaction_id).get();
		Account acc = accDAO.findById(account_number).get();
		
		trans.setAccountTransaction(acc);
		acc.getTeam().add(trans);
		
		transDAO.save(trans);
		accDAO.save(acc);
		
		return trans;
	}
	
	
	
	//Associating Customer and Account (Many to Many)
	@Transactional
	public Account assignAccountToCustomer(int account_number, int cust_id) {
		Account acc = accDAO.findById(account_number).get();
		Customer cust = custDAO.findById(cust_id).get();
		
		acc.getCustomerAssigned().add(cust);
		accDAO.save(acc);
		
		return acc;
	}
	
}
