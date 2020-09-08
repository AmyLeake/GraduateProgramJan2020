package com.mastek.amyfarm2home;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.amyfarm2home.daos.CustomerJPADAO;
import com.mastek.amyfarm2home.daos.FarmerJPADAO;
import com.mastek.amyfarm2home.daos.OrderJPADAO;
import com.mastek.amyfarm2home.daos.ProductJPADAO;
import com.mastek.amyfarm2home.entities.Customer;
import com.mastek.amyfarm2home.entities.SubscriptionType;

@SpringBootTest
class Amyfarm2homeApplicationTests {
	
	//JPADAOs
	@Autowired
	CustomerJPADAO custDAO;
	
	@Autowired
	FarmerJPADAO farmDAO;
	
	@Autowired
	ProductJPADAO prodDAO;
	
	@Autowired
	OrderJPADAO orderDAO;
	
	//Test Begin
	
	//Add data tests
	
	/*@Test void testAddCustomer() {
		Customer cust = new Customer();
		
		cust.setCustomerName("Amy Leake");
		cust.setAddress("77A Queen Street, Sheffield");
		cust.setContactNumber("07734843299");
		cust.setEmail("amy.leake@mastek.com");
		cust.setSubscriptionType(SubscriptionType.MONTHLY);
		
		cust = custDAO.save(cust);
		
		System.out.println(cust);
		assertNotNull(cust, "Customer Not Added");
		
	}*/
	

}
