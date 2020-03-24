package com.mastek.catalog;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import com.mastek.catalog.entities.Ingredient;
import com.mastek.catalog.entities.Order;
import com.mastek.catalog.entities.Product;
import com.mastek.catalog.services.CategoryService;
import com.mastek.catalog.services.CustomerService;

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
	
	@Autowired
	CustomerService custSrv;
	
	@Autowired
	CategoryService catSrv;
	
	@Test
	void contextLoads() {
	}
	
	//List tests
	
	//LISTING ALL CUSTOMERS
	/*@Test
	void testListCustomers() {
		Iterable<Customer> custs = custDAO.findAll();
		assertNotNull(custs, "Customers Not Found");
		for (Customer customer : custs) {
			System.out.println(customer);
		}
	}*/
	
	//Add tests
	
	//ADDING A NEW CUSTOMER
	/*@Test
	void testCustomerAdd() {
		Customer cust = new Customer();
		cust.setcustomerName("Amy Leake");
		cust.setAddress("77a Queen Street, Mosborough. Sheffield");
		cust.setdateOfBirth("14/08/1997");
		
		cust = custDAO.save(cust);
		
		System.out.println(cust);
		assertNotNull(cust, "Employee Not Added");
		
	}*/
	
	//ADDING CATEGORIES
	/*@Test
	void testCategoryAdd() {
		Category cat = new Category();
		cat.setCategory_name(CategoryName.MENS);
		cat.setDescription("Latest fashin in the mens fashion industry.");
		cat.setTotal_items(4000);
		
		cat = catDAO.save(cat);
		
		System.out.println(cat);
		assertNotNull(cat, "Category Not Added");
		
	}*/
	
	//Ingredient
	/*@Test
	void testIngredientAdd() {
		Ingredient ing = new Ingredient();
		ing.setIngredient_name("Milk");
		ing.setQuantity_in_stock(50);
		
		ing = ingrDAO.save(ing);
		
		System.out.println(ing);
		assertNotNull(ing, "Ingredient Not Added");
	}*/
	
	//Order
	/*@Test
	void testOrderAdd() {
		Order ord = new Order();
		ord.setOrder_date(11012019);
		ord.setTotal_items_ordered(4);
		ord.setSubtotal(55.00);
		ord.setVat(0.2);
		ord.setOrder_total(60.00);
		
		ord = orderDAO.save(ord);
		assertNotNull(ord, "Order Not Added");
	}*/
	
	//Product
	/*@Test
	void testProductAdd() {
		Product prod = new Product();
		prod.setProduct_name("Ivory Organza Sleeve Button Through Blouse");
		prod.setDescription("This organza sleeve button through blouse adds a sheer elegance to your wardrobe. Whether you wear your during day or elevated in the evening, this piece is such a Topshop classic. 81% Viscose, 19% Polyamide. Machine wash.");
		prod.setPrice(29.00);
		prod.setQuantity_in_stock(25);
		
		prod = prodDAO.save(prod);
		assertNotNull(prod, "Product Not Added");
	}
	*/
	
	//Delete Tests
	
	//DELETING CUSTOMERS BY THEIR ID
	/*@Test
	void testDeleteCustomerById() {
		custDAO.deleteById(55);
	}*/
	
	//Assigning Entities	
	
	//Customer and Order
	
/*	@Test
	void testAssignOrderToCustomer() {
		Order ord = custSrv.assignOrderToCustomer(67, 10);
		assertNotNull(ord.getCustomerOrder(),"Order Not Assigned");
	}*/
	
	
	//Order and Product
	/*@Test
	void testAssignProductToOrder() {
		Product prod = catSrv.assignProductToOrder(12, 7);
		assertTrue(prod.getProductsOrdered().size()>0, "Product Assigned");
	}*/
	
	//Order and Ingredient
	/*@Test
	void testAssignIngredientToOrder() {
		Ingredient ing = catSrv.assignIngredientToOrder(10, 8);
		assertTrue(ing.getIngredientOrdered().size()>0, "Ingredient Assigned");
	}*/
	
	//Product and Category
	/*@Test
	void testAssignProductToCategory() {
		Product prod = catSrv.assignProductToCategory(40, 1);
		assertNotNull(prod.getProductCategory(), "Product Not Assigned");
	}*/
	
	//Ingredient and Category
	/*@Test
	void testAssignIngredientToCategory() {
		Ingredient ing = catSrv.assignIngredientToCategory(6, 4);
		assertNotNull(ing.getIngredientCategory(), "Ingredient Not Assigned");
	}
*/
	
}
