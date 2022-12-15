package com.works.creationalpatterns.factorypattern.model;

//  Super Class
public abstract class Phone {
	
	public abstract String getModel();
	public abstract String getRam();
	public abstract String getMemory();

	@Override
	public String toString() {
		return "Model = " + this.getModel() + ", Ram = " + this.getRam() + ", Memory = " + this.getMemory();
	}
}
