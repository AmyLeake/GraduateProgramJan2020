package com.mastek.catalog.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastek.catalog.apis.ProductAPI;
import com.mastek.catalog.dao.ProductJPADAO;
import com.mastek.catalog.entities.Product;

public class ProductService implements ProductAPI{
	
	@Autowired
	ProductJPADAO prodDAO;

	//Initialising the service
	
	public ProductService() {
		System.out.println("Product Service Created");
	}
		
	@PostConstruct // initialise method of the class
	public void initialService() {
		System.out.println("Product Service Initialised");
	}
		
	@PreDestroy // Calls before the shutting down of the application
	public void terminateService() {
		System.out.println("Product Service Terminated");
	}

	//API method logic
	
	@Override
	public Iterable<Product> listAllProducts() {
		System.out.println("Listing all Products");
		return prodDAO.findAll();
	}

	@Override
	public Product findByProductId(int productId) {
		return prodDAO.findById(productId).get();
	}

	@Override
	public Product registerNewProduct(Product newProduct) {
		newProduct = prodDAO.save(newProduct);
		return newProduct;
	}
	
}
