package com.mastek.catalog.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.catalog.apis.IngredientAPI;
import com.mastek.catalog.dao.IngredientJPADAO;
import com.mastek.catalog.entities.Ingredient;

@Component
@Scope("singleton")
public class IngredientService implements IngredientAPI{
	
	@Autowired
	IngredientJPADAO ingDAO;
	
	//Initialising the service
	
	public IngredientService() {
		System.out.println("Ingredient Service Created");
	}
	
	@PostConstruct // initialise method of the class
	public void initialService() {
		System.out.println("Ingredient Service Initialised");
	}
	
	@PreDestroy // Calls before the shutting down of the application
	public void terminateService() {
		System.out.println("Ingredient Service Terminated");
	}

		
	//API method logic
	
	@Override
	public Iterable<Ingredient> listAllIngredients() {
		System.out.println("Listing all Ingredients");
		return ingDAO.findAll();
	}

	@Override
	public Ingredient findByIngredientId(int ingredientId) {
		return ingDAO.findById(ingredientId).get();
	}

	@Override
	public Ingredient registerNewIngredient(Ingredient newIngredient) {
		newIngredient = ingDAO.save(newIngredient);
		return newIngredient;
	}

}
