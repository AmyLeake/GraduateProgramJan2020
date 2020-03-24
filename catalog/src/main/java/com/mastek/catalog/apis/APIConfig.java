package com.mastek.catalog.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastek.catalog.services.CategoryService;
import com.mastek.catalog.services.CustomerService;
import com.mastek.catalog.services.IngredientService;
import com.mastek.catalog.services.OrderService;
import com.mastek.catalog.services.ProductService;

@Component
public class APIConfig extends ResourceConfig{

	public APIConfig() {
		
		//enables the CORS filter for UI applications to access the service
		register(CORSFilter.class);
		
		//Register each service class to enable services as API.
		register(CustomerService.class);
		
		register(CategoryService.class);
		
		register(ProductService.class);
		
		register(IngredientService.class);
		
		register(OrderService.class);
	}
}
