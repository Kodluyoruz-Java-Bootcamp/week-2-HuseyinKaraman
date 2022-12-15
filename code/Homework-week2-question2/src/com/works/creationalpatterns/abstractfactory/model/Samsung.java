package com.works.creationalpatterns.abstractfactory.model;

// Subclasses
public class Samsung extends Phone {

	private String model;
	private String ram;
	private String memory;
	
	public Samsung(String model, String ram, String memory) {
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
