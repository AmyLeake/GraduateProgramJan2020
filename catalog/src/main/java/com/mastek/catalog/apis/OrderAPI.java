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

import com.mastek.catalog.entities.Ingredient;
import com.mastek.catalog.entities.Order;
import com.mastek.catalog.entities.Product;

@Path("/catalog")
public interface OrderAPI {

	//List all Orders
	@GET
	@Path("/orders/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
	public Iterable<Order> listAllOrders();
	
	//Find order by ID
	@GET
	@Path("/orders/find/{orderId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Order findByOrderId(@PathParam("orderId") int orderId);
	
	//Register a new order
	@POST
	@Path("/order/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Order registerNewOrder(@BeanParam Order newOrder);
	
	//Find products ordered
	@GET
	@Path("/order/product/{orderId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Product> getProductsOrdered(@PathParam("orderId") int orderId);
	
	//Register product for an order
	@POST
	@Path("/order/product/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Product registerProductForOrder(
			@FormParam("orderId") int orderId,
			@BeanParam Product newProduct);
	
	//Find ingredients ordered
	@GET
	@Path("/order/ingredient/{orderId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Ingredient> getIngredientsOrdered(@PathParam("orderId") int orderId);
	
	//Register ingredient for order
	@POST
	@Path("/order/ingredient/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Ingredient registerIngredientForOrder(
			@FormParam("orderId") int orderId,
			@BeanParam Ingredient newIngredient);
	
	
}
