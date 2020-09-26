package com.example.java8demo;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class Java8demoApplicationTests {
	
	public Java8demoApplicationTests(){
		
	}

	@Test
	public void contextLoads() {
	}
	
//	  @Autowired
//	    private TestEntityManager entityManager;
	
	@Autowired
	EmployeeRepository repository;
	
	
//	@Test
	public void findAllEmployees() {
		List<Employee> employees = repository.findAll();
		System.out.println(employees);
		
		Employee[] ees = employees.stream().toArray(Employee[]:: new);
		System.out.println(ees);
		
//		Optional<Employee> employee = repository.findById(5);
	
//		System.out.println(employee.);
//		if(employee.isPresent()){
//			System.out.println(employee.get());
//		}
		
		Integer[] empIds = { 5,6,7,8 };
	    
	    Optional<Employee> employee = Stream.of(empIds)
	      .map(repository::findById)
	      .filter(e -> e != null)
	      .filter(e -> e.get().getSalary() > 35000)
	      .findFirst()
	      .orElse(null);
	    
	    System.out.println("****" + employee.get());
	    
	    
	    List<Optional<Employee>> emps = Stream.of(empIds)
	    	      .map(repository::findById)
	    	      .collect(Collectors.toList());
	    
	    emps.forEach(System.out::println);
	    	    
//	    
//	    assertEquals(employee.getSalary(), new Double(200000));
	}
	
//	@Test
	public void addEmployees() {
		List<Employee> employees = new ArrayList<>();
		Employee emp1 = new Employee(23, "Ravi", "Kumar", 34343.343);
		Employee emp3 = new Employee(3, "Amit", "Sharma", 54343.343);
		Employee emp2 = new Employee(13, "Venkat", "Raju", 44343.343);
		Employee emp4 = new Employee(43, "Karthik", "Kumar", 24343.343);
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		
		for(Employee e : employees){
			repository.save(e);
		}
//		repository.save(arg0);
		
	}
	
//	@Test
	public void sortEmployees(){
		
		Integer[] empIds = { 5,6,7,8 };
	    
		List<Optional<Employee>> employees = Stream.of(empIds)
	      .map(repository::findById)
			      .sorted((e1, e2) -> e1.get().getFirstName().compareTo(e2.get().getFirstName()))
			      .collect(Collectors.toList());
		
		System.out.println(employees);
	}
	
	
//	@Test
	public void getMinimum(){
		
		Integer[] empIds = { 5,6,7,8 };
	    
		Optional<Employee> employee = Stream.of(empIds)
	      .map(repository::findById)
	      .min((e1, e2) -> e1.get().getSalary().intValue() - e2.get().getSalary().intValue())
	      .orElseThrow(NoSuchElementException::new);
		
		System.out.println(employee);
	}
	
//	@Test
	public void getMinimumByMapToInt(){
		
		List<Employee> employees = repository.findAll();
		System.out.println(employees);
	    
		Integer latestEmpId = employees.stream()
			      .mapToInt(Employee::getId)
			      .max()
			      .orElseThrow(NoSuchElementException::new);
		
		
		
		System.out.println(latestEmpId);
		
//		IntStream.of(1, 2, 3);
//		IntStream.range(10, 20)
//		Stream.of(1, 2, 3) -- Not this
	}
	
//	@Test
	public void reduceValue(){
		List<Employee> employees = repository.findAll();
		Double sumSal = employees.stream()
			      .map(Employee::getSalary)
			      .reduce(0.0, Double::sum);
		System.out.println(sumSal);
	}
	
	
	@Test
	public void advanceCollectors(){
		
		//Joining
		List<Employee> employees = repository.findAll();
		String empNames = employees.stream()
			      .map(Employee::getFirstName)
			      .collect(Collectors.joining(", "))
			      .toString();
		System.out.println(empNames);
		
		Set<String> empNamesSet = employees.stream()
	            .map(Employee::getFirstName)
	            .collect(Collectors.toSet());
		System.out.println(empNamesSet);
		
		Vector<String> empNamesVector = employees.stream()
	            .map(Employee::getFirstName)
	            .collect(Collectors.toCollection(Vector::new));
		System.out.println(empNamesVector);
		
		//summary
		DoubleSummaryStatistics stats = employees.stream()
			      .collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(stats);
		
		//partitioningBy
		Map<Boolean, List<Employee>> isEven = employees.stream().collect(
			      Collectors.partitioningBy(e -> e.getId() % 2 == 0));
		System.out.println(isEven.get(true));
		System.out.println(isEven.get(false));
		
		//groupingBy
		Map<Character, List<Employee>> groupByAlphabet = employees.stream().collect(
			      Collectors.groupingBy(e -> new Character(e.getLastName().charAt(0))));
		System.out.println(groupByAlphabet);
		
		Map<Character, List<Integer>> idGroupedByAlphabet = employees.stream().collect(
			      Collectors.groupingBy(e -> new Character(e.getLastName().charAt(0)),
			        Collectors.mapping(Employee::getId, Collectors.toList())));
		System.out.println(idGroupedByAlphabet);

		
		
	}
	
	

}
