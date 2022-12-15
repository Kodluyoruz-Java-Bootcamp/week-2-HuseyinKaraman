package com.works.creationalpatterns.factorypattern.model;

// Subclasses
public class Iphone extends Phone {

	private String model;
	private String ram;
	private String memory;
	
	public Iphone(String model, String ram, String memory) {
		this.model = model;
		this.ram = ram;
		this.memory = memory;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public String getRam() {
		return this.ram;
	}

	@Override
	public String getMemory() {
		return this.memory;
	}
	

}
