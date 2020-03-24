package com.mastek.catalog.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.catalog.entities.Category;

@Path("/catalog")
public interface CategoryAPI {
	
	//List all categories
	@GET
	@Path("/category/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
	public Iterable<Category> listAllCategories();
	
	//Find a category by its ID
	@GET
	@Path("/category/find/{categoryId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Category findByCategoryId(@PathParam("categoryId") int categoryId);
	
	//Register a new category
	@POST
	@Path("/category/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Category registerNewCategory(@BeanParam Category newCategory);
	

}
