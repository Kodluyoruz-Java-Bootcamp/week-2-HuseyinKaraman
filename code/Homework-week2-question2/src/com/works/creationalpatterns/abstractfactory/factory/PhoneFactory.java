package com.works.creationalpatterns.abstractfactory.factory;

import com.works.creationalpatterns.abstractfactory.model.Phone;

public class PhoneFactory {

	public static Phone getPhone(PhoneAbstractFactory factory){
		return factory.createPhone();
	}
	
}
