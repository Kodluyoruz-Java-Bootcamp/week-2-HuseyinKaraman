package com.works.creationalpatterns.builder;

public class EmployeNotHaveBuilder {
	private String firstName;
	private String lastName;
	private int age; 
	private String phone; 
	private String address;
	
	public EmployeNotHaveBuilder() {}
	public EmployeNotHaveBuilder(String firstName, String lastName, int age, String phone, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	public EmployeNotHaveBuilder(String lastName, int age, String phone, String address) {}
	public EmployeNotHaveBuilder(int age, String phone, String address) {}
	public EmployeNotHaveBuilder(String firstName, String lastName, int age) {}
	public EmployeNotHaveBuilder(String firstName, String lastName,String phone, String address) {}
	public EmployeNotHaveBuilder(String firstName, String lastName, int age, String phone) {}
	public EmployeNotHaveBuilder(int age,String firstName, String lastName, String phone) {}
	public EmployeNotHaveBuilder(String firstName, String lastName, String phone) {}
	public EmployeNotHaveBuilder(String firstName,int age) {}
	public EmployeNotHaveBuilder(String firstName, String lastName) {}
	
}
