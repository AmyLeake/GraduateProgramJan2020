package com.mastek.bankservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.bankservice.dao.AccountJPADAO;
import com.mastek.bankservice.dao.CustomerJPADAO;
import com.mastek.bankservice.dao.TransactionJPADAO;
import com.mastek.bankservice.entities.Account;
import com.mastek.bankservice.entities.ActiveAccount;
import com.mastek.bankservice.entities.Customer;
import com.mastek.bankservice.entities.Transaction;
import com.mastek.bankservice.services.BankService;

@SpringBootTest
class BankserviceApplicationTests {
	
	@Autowired
	CustomerJPADAO custDAO;
	
	@Autowired
	AccountJPADAO accDAO;
	
	@Autowired
	TransactionJPADAO transDOA;
	
	@Autowired
	BankService bnkSvc;

	@Test
	void contextLoads() {
	}
	
/*	@Test
	void testCustomerDAOAdd() {
		Customer cust = new Customer();
		cust.setFirst_name("Jacob");
		cust.setSurname("Mathews");
		cust.setAddress("102 Sweet Road");
		cust.setTown("Wigginton");
		cust.setCity("York");
		cust.setPcode("YO32 2AB");
		cust.setNumber_of_accounts(2);
		
		cust = custDAO.save(cust);
		
		System.out.println(cust);
		assertNotNull(cust, "Customer Not Added");
	}*/
/*
	@Test
	void testAccountDAOAdd( ) {
		Account acc = new Account();
		acc.setAccount_type(ActiveAccount.ISA);
		acc.setSort_code(2002);
		acc.setTotal(400.00);
		
		acc = accDAO.save(acc);
		
		System.out.println(acc);
		assertNotNull(acc, "Account Not Added");
		
	}*/
	
	
	/*@Test
	void testTransactionDAOAdd() {
		Transaction trans = new Transaction();
		trans.setTransaction_date("02/12/2019");
		trans.setAccount_from(11);
		trans.setAccount_to(9);
		trans.setDescription("Groceries");
		trans.setTransaction_total(50.00);
		
		trans = transDOA.save(trans);
		
		System.out.println(trans);
		assertNotNull(trans, "Transaction Not Added");
		
	}
	*/
	
	@Test
	void testAssignAccountToCustomer() {
		Account acc = bnkSvc.assignAccountToCustomer(5, 10);
		assertTrue(acc.getCustomerAssigned().size()>0,"Customer Assigned");
	}
	
	/*@Test
	void testAssignTransactionToAccount() {
		Transaction trans = bnkSvc.assignTransactionToAccount(6, 2);
		assertNotNull(trans.getAccountTransaction(), "Transaction Not Assigned");
	}*/
	
}
