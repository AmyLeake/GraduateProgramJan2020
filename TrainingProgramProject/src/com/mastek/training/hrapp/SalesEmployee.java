package com.mastek.training.hrapp;

// Each class specifies their base/parent class name using extends keyword
//if the class does not have extends keyword it is default inheriting java.lang.Object
public class SalesEmployee extends Employee {
	
	private long target;
	private double commission;
	
	public SalesEmployee() {
		// use super keyword to call the base class constructor from the child/derived class
		//super constructor call must be the first line in the constructor.
		super(7777,"Sales Example", 99, Designations.MANAGER); 
		System.out.println("Sales Employee Created");
	}
	
	//Method Overriding 
	//Write the same method available in the base class in child class with different or additional logic for processing the result.
	
	@Override
	public double getNetSalary(int noOfDays) throws Exception {
		return super.getNetSalary(noOfDays)+(super.getNetSalary(noOfDays)*getCommission());
	}

	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	
}
