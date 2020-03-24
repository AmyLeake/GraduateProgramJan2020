package com.mastek.catalog.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.catalog.entities.Product;

@Path("/catalog")
public interface ProductAPI {

	//List all products
	@GET
	@Path("/products/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
	public Iterable<Product> listAllProducts();
	
	//Find a product by ID
	@GET
	@Path("/products/find/{productId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Product findByProductId(@PathParam("productId") int productId);
	
	//Register a new product
	@POST
	@Path("/product/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Product registerNewProduct(@BeanParam Product newProduct);
	
}
