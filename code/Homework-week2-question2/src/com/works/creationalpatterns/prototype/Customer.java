package com.works.creationalpatterns.prototype;

public class Customer implements Prototype{
	
	private int id;
	private String username;
	private int age;
	private String address;
	
	public Customer() {}

	public Customer(int id, String username, int age, String address) {
		this.id = id;
		this.username = username;
		this.age = age;
		this.address = address;
	}
	
	public void showInfo() {
		System.out.format("%-4d  %15s %5d %10s\n", id,username,age,address);
	}
	

	@Override
	public Prototype getClone() {
		return new Customer(id,username,age,address);
	}
	
}
