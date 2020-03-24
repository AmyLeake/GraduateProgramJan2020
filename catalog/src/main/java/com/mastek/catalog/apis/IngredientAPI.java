package com.mastek.catalog.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.catalog.entities.Ingredient;

@Path("/catalog")
public interface IngredientAPI {
	
	//List all Ingredients
	@GET
	@Path("/ingredients/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
	public Iterable<Ingredient> listAllIngredients();
	
	//Find ingredient byID
	@GET
	@Path("/ingredients/find/{ingredientId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Ingredient findByIngredientId(@PathParam("ingredientId") int ingredientId);
	
	//Register a new ingredient
	@POST
	@Path("/ingredients/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Ingredient registerNewIngredient(@BeanParam Ingredient newIngredient);
	
}
