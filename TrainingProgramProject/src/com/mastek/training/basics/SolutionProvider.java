package com.mastek.training.basics;

public class SolutionProvider {
	

	/* Take two numbers from the user and display the maximum number as output. */
	
	/* Public static <return-datatype> <name>(<param_type1> <param_name1> ...) */
	
	
	public static int getMaxNumber(int num1, int num2) { //declare inputs as params.
		int max=0; // declare output as a local variable.
		if (num1>num2) { // validate the conditions for logical result.
			max=num1;
		} else {
			max=num2;
		}
		return max; //return the result to the caller.
	}
	
	
	
	
	
	 // 1. Write an algorithm and code for accepting two numbers, divide the first number by second and display their quotient and remainder.
	 
	public static String getQuotientAndRemainder(int num1, int num2) {
		int quotient = (num1/num2);
		int remainder = (num1%num2);
		return (quotient+","+remainder);
		
	}
	
	
	// 2. Write an algorithm and code for accepting distance in kilometers, convert it into miles and display the result.
	
	public static String getKilometersInMiles(int num1) {
		int miles = (num1/8*5);
		return (miles+" "+"miles");		
	}


	// 3. Write an algorithm and code for calculating the area of rectangle and square separately.

	public static int getAreaOfRectangle(int num1, int num2) {
		int area1 = (num1*num2);
		return area1;
	}


	public static int getAreaOfSquare(int num1) {
		int area = (num1*num1);
		return area;
	}
}






