package com.works.creationalpatterns.singleton;

/**
 * Bir sınıfın sadece bir örneğinin olması istenildiği zamanlarda kullanılır.
 * @author hsykrmn
 */
public class Driver {

	public static void main(String[] args) {
		
		Singleton singleton = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		Singleton singleton3 = Singleton.getInstance();
		
		if ((singleton == singleton2) && singleton3 == singleton) {
			System.out.println("3 nesnede aynı yeri işaret eder.");
		}
		
	}

}
