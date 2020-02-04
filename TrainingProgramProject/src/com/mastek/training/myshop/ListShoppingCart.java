package com.mastek.training.myshop;

import java.util.LinkedList;
import java.util.List;

public class ListShoppingCart implements ShoppingCart<Item> {

	List<Item> items;
	
	public ListShoppingCart() {
		items = new LinkedList<Item>();
	}
	
	
	@Override
	public int addItem(Item i) {
		items.add(i);
		
		return items.size();
	}
	

	@Override
	public int removeItem(Item i) {
		System.out.println("Index of Item: "+items.indexOf(i));
		items.remove(i);
		return items.size();
	}

	@Override
	public void printItem() {
		System.out.println("Items in Cart");
		for (Item item : items) {
			System.out.println(item);
		}
	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		
		return 0;
	}

}
