package com.works.creationalpatterns.abstractfactory.factory;


import com.works.creationalpatterns.abstractfactory.model.Phone;
import com.works.creationalpatterns.abstractfactory.model.Samsung;

public class SamsungFactory extends PhoneAbstractFactory {

	private String model;
	private String ram;
	private String memory;
	
	public SamsungFactory(String model, String ram, String memory) {
		this.model = model;
		this.ram = ram;
		this.memory = memory;
	}


	@Override
	public Phone createPhone() {
		return new Samsung(model,ram,memory);
	}
	
}
