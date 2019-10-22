package com.cts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmployeeTestWithStandardLamdaFunctions {

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

		Collections.sort(employees, (e1, e2) -> e1.salary.compareTo(e2.salary));
//		Sorted List
		System.out.println("-------- Printing all sorted by salaries --------- ");
		printConditionally(employees, (e)-> true, (e) -> System.out.println(e));
//		2. Print each Employee object
//		3. Print Employee object where first name start with "R"
		System.out.println("-------- Printing all with name starting with R--------- ");
		printConditionally(employees, (e) -> e.firstName.startsWith("R"), (e) -> System.out.println(e) );
		
//		4. Print Employee object where last name start with "R"
		System.out.println("-------- Printing all with lastname starting with R--------- ");
		printConditionally(employees, (e) -> e.lastName.startsWith("R"), (e) -> System.out.println(e));

	}

	static void printConditionally(List<Employee> employees, Predicate<Employee> predicate, Consumer<Employee> consumer){
		for(Employee e: employees){
			if(predicate.test(e)) {
				consumer.accept(e);
			}
		}
	}
}

