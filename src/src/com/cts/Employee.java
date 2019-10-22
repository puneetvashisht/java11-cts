package com.cts;

public class Employee {
	
	int id;
	String firstName;
	String lastName;
	Double salary;
	
	
	public Employee() {
		super();
	}


	public Employee(int id, String firstName, String lastName, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	};
	
	
	

}
