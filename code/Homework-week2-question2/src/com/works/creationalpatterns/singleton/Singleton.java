package com.works.creationalpatterns.singleton;

public class Singleton {
	/// Objeye ait tek INSTANCE property'si olacak.
	private static Singleton INSTANCE = new Singleton();
	
	// constructor ile instance olusturulmasını onlenir
	private Singleton() {}
	
	// Class uzerinde erişim izni var.
	public static Singleton getInstance() {
		return INSTANCE;
	}
}
