package com.works.creationalpatterns.builder;

public class Driver {

	public static void main(String[] args) {

		Employee build = new Employee.EmployeeBuilder("Huseyin", "Karaman")
									 .setAddress("istanbul")
									  .setPhone("123456789")
									  .setAge(29)
									  .build();

		
		Employee build1 = new Employee.EmployeeBuilder("Huseyin", "Karaman")
									   .setAge(29).build();

		
		System.out.println(build);
		System.out.println(build1);
	}

}
