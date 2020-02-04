package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.SolutionProvider;

class SolutionProviderTest {

	@Test
	void testGetMaxNumberValidParams() {
		// assert<condition>(<Expected-Result>,<call the function for actual result>,
		// 						<Message to display if Expected Result does not match Actual Result>);
		
		assertEquals(10,SolutionProvider.getMaxNumber(10, 2), "Invalid max number returned");
	}
	
	@Test
	void testGetMaxNumberEqualParams() {
		assertEquals(9,SolutionProvider.getMaxNumber(9, 9),"Invalid max number returned");
	}
	
	@Test
	void testGetMaxNumberNegativeValueParams() {
		assertEquals(-2,SolutionProvider.getMaxNumber(-110, -2),"Invalid max number returned");
	}
	
	@Test
	void testGetMaxNumberMaxLimitsForIntParams() {
		assertEquals(999999999,SolutionProvider.getMaxNumber(999999999, 2),"Invalid max number returned");
	}

}
