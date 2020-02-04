package com.mastek.training.myshop;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetShoppingCart implements ShoppingCart<Item> {

	Set<Item> items;
	
	//Constructor.
	public SetShoppingCart() {
		//using asset to manage unique items in a random order.
		//items = new HashSet<>(); //diamond operator with new keyword since jdk 1.7.
			// new HashSet of <Item>();
		
		//using TreeSet to store items in a sorted order
		items = new TreeSet<>();
	}
	
	@Override
	public int addItem(Item i) {
		items.add(i);
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		items.remove(i);
		return items.size();
	}

	@Override
	public void printItem() {
		for (Item item : items) {
			System.out.println(item);
		}
	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
