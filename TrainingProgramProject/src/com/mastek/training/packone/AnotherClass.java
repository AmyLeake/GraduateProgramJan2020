package com.mastek.training.packone;

public class AnotherClass {
	
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		//In the AnotherClass, of the same package, we can have access to all the types of members of the class, EXCEPT private members..
		System.out.println(
				//"Private: "+sc1.privateNumber+
				"\nDefault: "+sc1.defaultNumber+
				"\nProtected: "+sc1.protectedNumber+
				"\nPublic: "+sc1.publicNumber);
	}

}
