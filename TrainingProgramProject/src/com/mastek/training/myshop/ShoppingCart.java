package com.mastek.training.myshop;

//using generic type interface
//type <I>: would be defined at usage time with type of class
public interface ShoppingCart<I> {
	
	public int addItem(I i);
	public int removeItem(I i);
	public void printItem();
	public double getTotalPrice(double taxPercentage, double discountPercentage);
	
}
