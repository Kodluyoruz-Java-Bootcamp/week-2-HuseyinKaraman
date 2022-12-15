package com.works.creationalpatterns.abstractfactory.factory;

import com.works.creationalpatterns.abstractfactory.model.Phone;
import com.works.creationalpatterns.abstractfactory.model.Xiaomi;

public class XiaomiFactory extends PhoneAbstractFactory{
	
	private String model;
	private String ram;
	private String memory;
	
	public XiaomiFactory(String model, String ram, String memory) {
		this.model = model;
		this.ram = ram;
		this.memory = memory;
	}


	@Override
	public Phone createPhone() {
		return new Xiaomi(model,ram,memory);
	}
}
