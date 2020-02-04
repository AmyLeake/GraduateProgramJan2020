package com.mastek.training.packone;

public class DerivedClass extends SimpleClass {
	
	public static void main(String[] args) {
		DerivedClass sc1 = new DerivedClass();
		//In the AnotherClass, of the same package, we can have access to all the types of members of the class, EXCEPT private members..
		System.out.println(
				//"Private: "+sc1.privateNumber+
				"\nDefault: "+sc1.defaultNumber+
				"\nProtected: "+sc1.protectedNumber+
				"\nPublic: "+sc1.publicNumber);
	}

}
