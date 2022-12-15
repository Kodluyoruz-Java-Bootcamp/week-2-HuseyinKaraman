package com.works.creationalpatterns.builder;

public class Employee {

	private String firstName; // required
	private String lastName; // required

	private int age; // optional
	private String phone; // optional
	private String address; // optional

	public Employee(EmployeeBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Employee: " + this.firstName + ", " + this.lastName + ", " + this.age + ", " + this.phone + ", "
				+ this.address;
	}

	// Builder Class
	public static class EmployeeBuilder {

		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;
		private String address;

		public EmployeeBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public EmployeeBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public EmployeeBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public EmployeeBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}

	}
}
