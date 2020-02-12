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
	
	/*@Test
	void testCustomerDAOAdd() {
		Customer cust = new Customer();
		cust.setFirst_name("Karen");
		cust.setSurname("Leake");
		cust.setAddress("243 Birley Spa Lane");
		cust.setTown("Hackenthorpe");
		cust.setCity("Sheffield");
		cust.setPcode("S12 4BW");
		cust.setNumber_of_accounts(1);
		
		cust = custDAO.save(cust);
		
		System.out.println(cust);
		assertNotNull(cust, "Customer Not Added");
	}

	@Test
	void testAccountDAOAdd( ) {
		Account acc = new Account();
		acc.setAccount_type(ActiveAccount.current);
		acc.setSort_code(223344);
		acc.setTotal(2000.00);
		
		acc = accDAO.save(acc);
		
		System.out.println(acc);
		assertNotNull(acc, "Account Not Added");
		
	}*/
	
	
/*	@Test
	void testTransactionDAOAdd() {
		Transaction trans = new Transaction();
		trans.setTransaction_date("12/20/2020");
		trans.setAccount_from(2);
		trans.setAccount_to(5);
		trans.setDescription("Drinks");
		trans.setTransaction_total(20.00);
		
		trans = transDOA.save(trans);
		
		System.out.println(trans);
		assertNotNull(trans, "Transaction Not Added");
		
	}*/
	
	
	/*@Test
	void testAssignAccountToCustomer() {
		Account acc = bnkSvc.assignAccountToCustomer(2, 2);
		assertTrue(acc.getCustomerAssigned().size()>0,"Customer Assigned");
	}*/
	
	@Test
	void testAssignTransactionToAccount() {
		Transaction trans = bnkSvc.assignTransactionToAccount(6, 2);
		assertNotNull(trans.getAccountTransaction(), "Transaction Not Assigned");
	}
	
}
