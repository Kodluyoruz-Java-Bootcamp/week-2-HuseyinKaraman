package com.works.creationalpatterns.abstractfactory.factory;

import com.works.creationalpatterns.abstractfactory.model.Phone;

// Abstract Factory interface veya abstract class olabilir 
public abstract class  PhoneAbstractFactory {

	public abstract Phone createPhone();
	
}
