package com.mastek.training.packone;

//interface: a type which contain only method declarations and constraints
// the interface does not extend any existing type.
public interface Shape {
	//no constructor can be defined in interfaces
	
	//all variables are static and final
	double PI = Math.PI;
	
	//all methods are abstract
	public double getArea();
	public double getPerimeter();

}
