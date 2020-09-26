package com.myown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





public class EmployeeTestLamda {

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
		
		// Sort 
//		System.out.println(employees);
		
		
//		Collections.sort(employees, new Comparator<Employee>(){
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				return o1.getFirstName().compareTo(o2.getLastName());
//				
//			}
//			
//		});
		
		Collections.sort(employees, (o1, o2)-> o1.getFirstName().compareTo(o2.getLastName()) );
		
		// Print conditinally & all
		
		
		printEmployees(employees, (e)-> true);
		printEmployees(employees, (e)-> e.getFirstName().startsWith("K"));

	}
	
	
	static void printEmployees(List<Employee> employees, Condition condition){
		for(Employee e : employees){
			if(condition.test(e)){
				System.out.println(e);
			}
		}
		
		
	}

}

interface Condition{
	boolean test(Employee e);
}
