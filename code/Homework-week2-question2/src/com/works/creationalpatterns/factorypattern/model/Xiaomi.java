package com.works.creationalpatterns.factorypattern.model;

public class Xiaomi extends Phone {

	private String model;
	private String ram;
	private String memory;
	
	public Xiaomi(String model, String ram, String memory) {
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
