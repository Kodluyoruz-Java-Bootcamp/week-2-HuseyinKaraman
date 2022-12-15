package com.works.creationalpatterns.factorypattern.test;

import com.works.creationalpatterns.factorypattern.factory.PhoneFactory;
import com.works.creationalpatterns.factorypattern.model.Phone;


/**
 * 
 * 
 * @author hsykrmn
 */
public class Driver {
	
	public static void main(String[] args) {
		
		Phone samsung = PhoneFactory.getPhone("samsung","S9","2gb","16gb");
		Phone xiaomi  =  PhoneFactory.getPhone("xiaomi","Note 6 pro","6gb","64gb");
		Phone iphone  =  PhoneFactory.getPhone("iphone","Iphone 7","3gb","32gb");
		
		System.out.println("Samsung :: " + samsung);
		System.out.println("Xiaomi :: " + xiaomi);
		System.out.println("Iphone :: " + iphone);
		
	}
}
