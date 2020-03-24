package com.mastek.catalog.services;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastek.catalog.apis.OrderAPI;
import com.mastek.catalog.dao.IngredientJPADAO;
import com.mastek.catalog.dao.OrderJPADAO;
import com.mastek.catalog.dao.ProductJPADAO;
import com.mastek.catalog.entities.Ingredient;
import com.mastek.catalog.entities.Order;
import com.mastek.catalog.entities.Product;

public class OrderService implements OrderAPI{
	
	@Autowired
	OrderJPADAO ordDAO;
	
	@Autowired
	ProductJPADAO prodDAO;
	
	@Autowired
	IngredientJPADAO ingDAO;
	
	//Initialising the service
	
	public OrderService() {
		System.out.println("Order Service Created");
	}
		
	@PostConstruct // initialise method of the class
	public void initialService() {
		System.out.println("Order Service Initialised");
	}
	
	@PreDestroy // Calls before the shutting down of the application
	public void terminateService() {
		System.out.println("Order Service Terminated");
	}
	
	//Associations
	
	//Order and Product
	@Transactional
	public Product assignProductToOrder(int productId, int orderId) {
		Product prod = prodDAO.findById(productId).get();
		Order ord = ordDAO.findById(orderId).get();
		
		prod.getProductsOrdered().add(ord);
		prodDAO.save(prod);
		
		return prod;
	}
		
	//Order and Ingredient
	
	@Transactional
	public Ingredient assignIngredientToOrder(int ingredientId, int orderId) {
		Ingredient ing = ingDAO.findById(ingredientId).get();
		Order ord = ordDAO.findById(orderId).get();
		
		ing.getIngredientOrdered().add(ord);
		ingDAO.save(ing);
		
		return ing;
	}
	
	
	//API method logic

	@Override
	public Iterable<Order> listAllOrders() {
		System.out.println("Listing all Orders");
		return ordDAO.findAll();
	}

	@Override
	public Order findByOrderId(int orderId) {
		return ordDAO.findById(orderId).get();
	}

	//register new order
	
	@Override
	public Order registerNewOrder(Order newOrder) {
		newOrder = ordDAO.save(newOrder);
		return newOrder;
	}	
	
	

	@Override
	@Transactional
	public Set<Product> getProductsOrdered(int orderId) {
		Order currentOrd = ordDAO.findById(orderId).get();
		int count = currentOrd.getOrderedProducts().size();
		
		System.out.println(count+" products found");
		
		Set<Product> products = currentOrd.getOrderedProducts();
		return products;
	}

	@Override
	@Transactional
	public Product registerProductForOrder(int orderId, Product newProduct) {
		newProduct = prodDAO.save(newProduct);
		assignProductToOrder(orderId, newProduct.getProductId());
		return newProduct;
	}

	@Override
	@Transactional
	public Set<Ingredient> getIngredientsOrdered(int orderId) {
		Order currentOrd = ordDAO.findById(orderId).get();
		int count = currentOrd.getOrderedIngredients().size();
		
		System.out.println(count +"Ingredients Found");
		
		Set<Ingredient> ingredients = currentOrd.getOrderedIngredients();
		return ingredients;
	}

	@Override
	@Transactional
	public Ingredient registerIngredientForOrder(int orderId, Ingredient newIngredient) {
		newIngredient = ingDAO.save(newIngredient);
		assignIngredientToOrder(orderId, newIngredient.getIngredientId());
		return newIngredient;
	}


}
