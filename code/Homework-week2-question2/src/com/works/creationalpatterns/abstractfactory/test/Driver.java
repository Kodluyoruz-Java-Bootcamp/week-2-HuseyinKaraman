package com.works.creationalpatterns.abstractfactory.test;

import com.works.creationalpatterns.abstractfactory.factory.IphoneFactory;
import com.works.creationalpatterns.abstractfactory.factory.PhoneAbstractFactory;
import com.works.creationalpatterns.abstractfactory.factory.PhoneFactory;
import com.works.creationalpatterns.abstractfactory.factory.SamsungFactory;
import com.works.creationalpatterns.abstractfactory.factory.XiaomiFactory;
import com.works.creationalpatterns.abstractfactory.model.Phone;

public class Driver {
	
	public static void main(String[] args) {
		
		PhoneAbstractFactory samsungFactory = new SamsungFactory("S11", "4gb", "64gb");
		PhoneAbstractFactory iphoneFactory = new IphoneFactory("Iphone 13", "8gb", "128gb");
		PhoneAbstractFactory xiaomiFactory = new XiaomiFactory("Redmi 10", "8gb", "128gb");
		
		Phone samsung = PhoneFactory.getPhone(samsungFactory);
		Phone iphone  =  PhoneFactory.getPhone(iphoneFactory);
		Phone xiaomi  =  PhoneFactory.getPhone(xiaomiFactory);
		
		System.out.println("Samsung :: " + samsung);
		System.out.println("Iphone :: " + iphone);
		System.out.println("Xiaomi :: " + xiaomi);
		
	}
}
