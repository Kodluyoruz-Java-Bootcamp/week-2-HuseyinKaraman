package com.works.creationalpatterns.factorypattern.factory;

import com.works.creationalpatterns.factorypattern.model.Phone;
import com.works.creationalpatterns.factorypattern.model.Xiaomi;
import com.works.creationalpatterns.factorypattern.model.Iphone;
import com.works.creationalpatterns.factorypattern.model.Samsung;

public class PhoneFactory {

	public static Phone getPhone(String type, String model, String ram, String memory) {
		if ("Iphone".equalsIgnoreCase(type))
			return new Iphone(model, ram, memory);
		else if ("Samsung".equalsIgnoreCase(type))
			return new Samsung(model, ram, memory);
		else if ("Xiaomi".equalsIgnoreCase(type))
			return new Xiaomi(model, ram, memory);		
		
		return null;
	}

}
