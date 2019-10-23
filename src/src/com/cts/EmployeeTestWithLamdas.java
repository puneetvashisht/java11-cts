package com.cts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeTestWithLamdas {

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
		
//		System.out.println(employees);
		
//		1. For in loop
		System.out.println("---- For In  -----");
		for(Employee e: employees){
				System.out.println(e);
		}
		
//		2. For each loop
		System.out.println("---- For each  -----");
		employees.forEach((e)-> System.out.println(e));	
		System.out.println("---- For each with Method References  -----");
		employees.forEach(System.out :: println);
		
//		1. Lamda for sorting Employees by salaries (increasing)
//		Collections.sort(employees, ___ lamda ____);

		Collections.sort(employees, (e1, e2) -> e1.salary.compareTo(e2.salary));
//		Sorted List
		System.out.println("-------- Printing all sorted by salaries --------- ");
//		printConditionally(employees, (e)-> true);
//		2. Print each Employee object
//		3. Print Employee object where first name start with "R"
		System.out.println("-------- Printing all with name starting with R--------- ");
//		printConditionally(employees, (e) -> e.firstName.startsWith("R") );
		
//		4. Print Employee object where last name start with "R"
		System.out.println("-------- Printing all with lastname starting with R--------- ");
//		printConditionally(employees, (e) -> e.lastName.startsWith("R"));
		
		
//		5. Streams 
		System.out.println("------- STREAMS ---------");
		long totalFilteredEmployees = employees.stream().filter((e) -> e.lastName.startsWith("R")).count();
//		System.out.println(totalFilteredEmployees);
		
		employees.stream().filter((e) -> e.lastName.startsWith("R")).forEach(e -> System.out.println(e));
		// Method reference
		employees.stream().filter((e) -> e.lastName.startsWith("R")).forEach(System.out::println);

	}

	static void printConditionally(List<Employee> employees, Condition condition){
		for(Employee e: employees){
			if(condition.test(e)) {
				System.out.println(e);
			}
		}
	}
}

