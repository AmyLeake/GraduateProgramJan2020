package com.mastek.catalog.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.catalog.apis.CategoryAPI;
import com.mastek.catalog.dao.CategoryJPADAO;
import com.mastek.catalog.dao.IngredientJPADAO;
import com.mastek.catalog.dao.ProductJPADAO;
import com.mastek.catalog.entities.Category;
import com.mastek.catalog.entities.Ingredient;
import com.mastek.catalog.entities.Product;

@Component
@Scope("singleton")
public class CategoryService implements CategoryAPI {
	
	@Autowired
	IngredientJPADAO ingDAO;
	
	@Autowired
	ProductJPADAO prodDAO;
	
	@Autowired
	CategoryJPADAO catDAO;

	//Initialising the service
	
	public CategoryService() {
		System.out.println("Category Service Created");
	}
	
	@PostConstruct // initialise method of the class
	public void initialService() {
		System.out.println("Category Service Initialised");
	}
	
	@PreDestroy // Calls before the shutting down of the application
	public void terminateService() {
		System.out.println("Category Service Terminated");
	}
	
	//Associations
	
	//Product and Category
	@Transactional
	public Product assignProductToCategory(int productId, int categoryId) {
		Product prod = prodDAO.findById(productId).get();
		Category cat = catDAO.findById(categoryId).get();
		
		prod.setProductCategory(cat);
		cat.getCurrentCategory().add(prod);
		
		prodDAO.save(prod);
		catDAO.save(cat);
		
		return prod;		
		
	}
	
	//Ingredient and Category
	@Transactional
	public Ingredient assignIngredientToCategory(int ingredientId, int categoryId) {
		Ingredient ing = ingDAO.findById(ingredientId).get();
		Category cat = catDAO.findById(categoryId).get();
		
		ing.setIngredientCategory(cat);
		cat.getCurrentIngredient().add(ing);
		
		ingDAO.save(ing);
		catDAO.save(cat);
		
		return ing;
	}
	
	//API method logic

	@Override
	public Iterable<Category> listAllCategories() {
		System.out.println("Listing all Categories");
		return catDAO.findAll();
	}

	@Override
	public Category findByCategoryId(int categoryId) {
		return catDAO.findById(categoryId).get();
	}

	@Override
	public Category registerNewCategory(Category newCategory) {
		newCategory = catDAO.save(newCategory);
		return newCategory;
	}
	
	
	
}
