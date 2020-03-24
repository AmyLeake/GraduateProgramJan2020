package com.mastek.catalog.apis;

import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.catalog.entities.Customer;
import com.mastek.catalog.entities.Order;

@Path("/catalog")
public interface CustomerAPI {
	
	//List all customers
	@GET
	@Path("/customer/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
	public Iterable<Customer> listAllCustomers();
	
	//Find a customer by ID
	@GET
	@Path("/customer/find/{customerId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Customer findByCustomerId(@PathParam("customerId") int customerId);
	
	//Register a new customer
	@POST
	@Path("/customer/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer registerNewCustomer(@BeanParam Customer newCustomer);
	
	//Find all customer orders
	@GET
	@Path("/customer/order/{customerId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Order> getCustomerOrders(@PathParam("customerId") int customerId);
	
	//Register an order to a customer
	@POST
	@Path("/customer/order/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Order registerOrderForEmployee(
			@FormParam("customerId") int customerId,
			@BeanParam Order newOrder);
}
