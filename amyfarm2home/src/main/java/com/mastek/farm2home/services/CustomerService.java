package com.mastek.farm2home.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.farm2home.daos.CustomerJPADAO;
import com.mastek.farm2home.daos.FarmerJPADAO;
import com.mastek.farm2home.daos.OrderJPADAO;
import com.mastek.farm2home.daos.ProductJPADAO;

@Component
@Scope("singleton")
public class CustomerService {
	
	@Autowired
	CustomerJPADAO custDAO;
	
	@Autowired
	FarmerJPADAO farmDAO;
	
	@Autowired
	ProductJPADAO prodDAO;
	
	@Autowired
	OrderJPADAO orderDAO;

}
