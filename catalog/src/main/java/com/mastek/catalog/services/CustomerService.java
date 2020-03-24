package com.mastek.catalog.services;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.catalog.apis.CustomerAPI;
import com.mastek.catalog.dao.CustomerJPADAO;
import com.mastek.catalog.dao.OrderJPADAO;
import com.mastek.catalog.entities.Customer;
import com.mastek.catalog.entities.Order;

@Component
@Scope("singleton")
public class CustomerService implements CustomerAPI{
	
	@Autowired
	CustomerJPADAO custDAO;
	
	@Autowired
	OrderJPADAO ordDAO;
	
	
	//Initialising the service
	
	public CustomerService() {
		System.out.println("Customer Service Created");
	}
	
	@PostConstruct // initialise method of the class
	public void initialService() {
		System.out.println("Customer Service Initialised");
	}
	
	@PreDestroy // Calls before the shutting down of the application
	public void terminateService() {
		System.out.println("Customer Service Terminated");
	}

	
	//Associations for entities
	
	//Customer and Order
	
	@Transactional
	public Order assignOrderToCustomer(int orderId, int customerId) {
		Order ord = ordDAO.findById(orderId).get();
		Customer cust = custDAO.findById(customerId).get();
		
		ord.setCustomerOrder(cust);
		cust.getOrderRecords().add(ord);
		
		ordDAO.save(ord);
		custDAO.save(cust);
		
		return ord;
	}
	
	
	
	//API method logic

	@Override
	public Iterable<Customer> listAllCustomers() {
		System.out.println("Listing all Customers");
		return custDAO.findAll();
	}

	@Override
	public Customer findByCustomerId(int customerId) {
		return custDAO.findById(customerId).get();
	}

	@Override
	public Customer registerNewCustomer(Customer newCustomer) {
		newCustomer = custDAO.save(newCustomer);
		return newCustomer;
	}

	@Override
	@Transactional
	public Set<Order> getCustomerOrders(int customerId) {
		Customer cust = custDAO.findById(customerId).get();
		int count = cust.getOrderRecords().size();
		
		System.out.println(count+" Orders Found");
		
		Set<Order> orders = cust.getOrderRecords();
		return orders;
	}

	@Override
	@Transactional
	public Order registerOrderForEmployee(int customerId, Order newOrder) {
		newOrder = ordDAO.save(newOrder);
		assignOrderToCustomer(customerId, newOrder.getOrderId());
		return newOrder;
	}
	
}
