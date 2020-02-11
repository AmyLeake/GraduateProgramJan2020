package com.mastek.catalog;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.catalog.dao.CategoryJPADAO;
import com.mastek.catalog.dao.CustomerJPADAO;
import com.mastek.catalog.dao.IngredientJPADAO;
import com.mastek.catalog.dao.OrderJPADAO;
import com.mastek.catalog.dao.ProductJPADAO;
import com.mastek.catalog.entities.Category;
import com.mastek.catalog.entities.CategoryName;
import com.mastek.catalog.entities.Customer;

@SpringBootTest
class CatalogApplicationTests {
	
	@Autowired
	CategoryJPADAO catDAO;
	
	@Autowired
	CustomerJPADAO custDAO;
	
	@Autowired
	IngredientJPADAO ingrDAO;
	
	@Autowired
	OrderJPADAO orderDAO;
	
	@Autowired
	ProductJPADAO prodDAO;
	
	@Test
	void contextLoads() {
	}
	
	//ADDING A NEW CUSTOMER
/*	@Test
	void testCustomerAdd() {
		Customer cust = new Customer();
		cust.setCustomer_name("Karen Leake");
		cust.setAddress("243 Birley Spa Lane, Hackenthorpe. Sheffield");
		cust.setDate_of_birth("20/09/1967");
		
		cust = custDAO.save(cust);
		
		System.out.println(cust);
		assertNotNull(cust, "Employee Not Added");
		
	}*/
		
	//LISTING ALL CUSTOMERS
	@Test
	void testListCustomers() {
		Iterable<Customer> custs = custDAO.findAll();
		assertNotNull(custs, "Customers Not Found");
		for (Customer customer : custs) {
			System.out.println(customer);
		}
	}
	
	//DELETING CUSTOMERS BY THEIR ID
/*	@Test
	void testDeleteCustomerById() {
		custDAO.deleteById(55);
	}*/

	//ADDING CATEGORIES
	@Test
	void testCategoryAdd() {
		Category cat = new Category();
		cat.setCategory_name(CategoryName.WOMENS);
		cat.setDescription("Formal and casual options available in multiple styles and colours.");
		cat.setTotal_items(1000);
		
		cat = catDAO.save(cat);
		
		System.out.println(cat);
		assertNotNull(cat, "Category Not Added");
		
	}
	
	
	
}
