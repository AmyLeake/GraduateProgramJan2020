package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class AnotherClass {
	
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		//In the AnotherClass, of the other package, we can only access public members of the class
		System.out.println(
				//"Private: "+sc1.privateNumber+
				//"\nDefault: "+sc1.defaultNumber+
				//"\nProtected: "+sc1.protectedNumber+
				"\nPublic: "+sc1.publicNumber);
	}

}
