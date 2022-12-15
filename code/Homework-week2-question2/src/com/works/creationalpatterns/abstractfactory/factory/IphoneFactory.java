package com.works.creationalpatterns.abstractfactory.factory;

import com.works.creationalpatterns.abstractfactory.model.Iphone;
import com.works.creationalpatterns.abstractfactory.model.Phone;

public class IphoneFactory extends PhoneAbstractFactory {

	private String model;
	private String ram;
	private String memory;
	
	public IphoneFactory(String model, String ram, String memory) {
		this.model = model;
		this.ram = ram;
		this.memory = memory;
	}

	@Override
	public Phone createPhone() {
		return new Iphone(model,ram,memory);
	}
	

}
