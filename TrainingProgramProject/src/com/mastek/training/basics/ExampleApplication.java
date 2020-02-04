package com.mastek.training.basics;

public class ExampleApplication {

	private static int getArea;

	public static void main(String[] args) {
		int maxResult = 0;
		String getQuotientAndRemainder = "";
		
		maxResult = SolutionProvider.getMaxNumber(10, 2);
		System.out.println("Max Result is "+maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(10, 10);
		System.out.println("Max Result is "+maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(-110, -2);
		System.out.println("Max Result is "+maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(999999999, 2);
		System.out.println("Max Result is "+maxResult);
		
		
		
		
		//1. Write an algorithm and code for accepting two numbers, divide the first number by second and display their quotient and remainder.
		
		getQuotientAndRemainder = SolutionProvider.getQuotientAndRemainder(13, 5);
		System.out.println(getQuotientAndRemainder);
		
		// 2. Write an algorithm and code for accepting distance in kilometers, convert it into miles and display the result.
		
		String getMiles = SolutionProvider.getKilometersInMiles(25);
		System.out.println(getMiles);
		
		// 3. Write an algorithm and code for calculating the area of rectangle and square separately.

		int getArea1 = SolutionProvider.getAreaOfRectangle(40, 10);
		System.out.println(getArea1);
		
		getArea = SolutionProvider.getAreaOfSquare(15);
		System.out.println(getArea);
	}
}