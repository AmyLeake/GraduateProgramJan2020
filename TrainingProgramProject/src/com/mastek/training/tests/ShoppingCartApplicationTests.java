package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.myshop.Item;
import com.mastek.training.myshop.ListShoppingCart;
import com.mastek.training.myshop.MapShoppingCart;
import com.mastek.training.myshop.SetShoppingCart;
import com.mastek.training.myshop.ShoppingCart;

class ShoppingCartApplicationTests {
	ShoppingCart<Item> sc;

	@BeforeEach
	void setUp() throws Exception {
		// sc = new ListShoppingCart(); List Example
		//sc = new SetShoppingCart(); //Set Example
		sc = new MapShoppingCart(); //Map Example
	}

	@AfterEach
	void tearDown() throws Exception {
		sc=null;
	}

	@Test
	void testShoppingCartAddItem() {
		int size = sc.addItem(new Item(1,"Name",233.0,1));  
		assertEquals(1,size,"ItemAdded");
	}
	
	@Test
	void testShoppingCartPrintItems() {
		sc.addItem(new Item(2,"Item 2",1233.0,1));
		sc.addItem(new Item(3,"Item 3",2233.0,1));
		sc.addItem(new Item(3,"Item 3",2233.0,1));
		sc.addItem(new Item(1,"Item 1",233.0,1));
		sc.addItem(new Item(2,"Item 2",1233.0,1));
		sc.addItem(new Item(1,"Item 1",233.0,1));
		sc.addItem(new Item(2,"Item 2",1233.0,1));

		
		sc.printItem();
	}

	@Test
	void testShoppingCartRemoveItems() {
		sc.addItem(new Item(1,"Item 1",233.0,1));
		sc.addItem(new Item(2,"Item 2",1233.0,1));
		sc.addItem(new Item(3,"Item 3",2233.0,1));
		sc.printItem();
	
	int size = sc.removeItem(new Item(2));
	sc.printItem();
	
	assertEquals(2,size,"Item Removed");
	
	}
}






