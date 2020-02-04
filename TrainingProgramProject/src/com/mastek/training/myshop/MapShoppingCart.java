package com.mastek.training.myshop;

import java.util.Map;
import java.util.TreeMap;

public class MapShoppingCart implements ShoppingCart<Item> {
	
	Map<Integer, Item> items;
	
	//constructor
	public MapShoppingCart() {
		//items = new HashMap<>(); //maintain random entries for the collection
		items = new TreeMap<>(); //treeMap sorts all the entries using the keys : itemId
	}

	@Override
	public int addItem(Item i) {
		items.put(i.getItemId(), i);	//map.put(key,value)
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		items.remove(i.getItemId());	//map.remove(key)
		return items.size();
	}

	@Override
	public void printItem() {
		System.out.println("Items in Cart");
		for (Integer itemId: items.keySet()) { // get all keys from the map
			Item i = items.get(itemId);	// gets the value from the map using the key
			System.out.println(i);
		}

	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
