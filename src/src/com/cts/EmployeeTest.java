package com.cts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeTest {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Employee emp1 = new Employee(23, "Ravi", "Kumar", 34343.343);
		Employee emp3 = new Employee(3, "Amit", "Sharma", 54343.343);
		Employee emp2 = new Employee(13, "Venkat", "Raju", 44343.343);
		Employee emp4 = new Employee(43, "Karthik", "Kumar", 24343.343);
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		
		System.out.println(employees);
		
//		1. Lamda for sorting Employees by salaries (increasing)
//		Collections.sort(employees, ___ lamda ____);
//		2. Print each Employee object
//		3. Print Employee object where first name start with "R"

	}

}
