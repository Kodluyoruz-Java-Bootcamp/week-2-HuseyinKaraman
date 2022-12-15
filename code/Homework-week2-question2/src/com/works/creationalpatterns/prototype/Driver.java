package com.works.creationalpatterns.prototype;

public class Driver {
	
	public static void main(String[] args) {
		
		Customer customer = new Customer(1, "huseyin karaman", 30, "Istanbul");
		customer.showInfo();
		
		Customer cloneCustomer = (Customer) customer.getClone();
		cloneCustomer.showInfo();
		
	}
}
