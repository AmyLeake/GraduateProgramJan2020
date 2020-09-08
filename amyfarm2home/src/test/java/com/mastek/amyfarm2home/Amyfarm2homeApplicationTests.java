package com.mastek.amyfarm2home;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.amyfarm2home.daos.CustomerJPADAO;
import com.mastek.amyfarm2home.daos.FarmerJPADAO;
import com.mastek.amyfarm2home.daos.OrderJPADAO;
import com.mastek.amyfarm2home.daos.ProductJPADAO;

@SpringBootTest
class Amyfarm2homeApplicationTests {
	
	//JPADAOs
	@Autowired
	CustomerJPADAO custDAO;
	
	@Autowired
	FarmerJPADAO farmDAO;
	
	@Autowired
	ProductJPADAO prodDAO;
	
	@Autowired
	OrderJPADAO orderDAO;
	
	//Test Begin

	@Test
	void contextLoads() {
	}

}
