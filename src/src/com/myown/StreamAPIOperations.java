package com.myown;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIOperations {
	
	
	
	

	public static void main(String[] args) {
		//FlatMap
		List<List<String>> namesNested = Arrays.asList( 
			      Arrays.asList("Jeff", "Bezos"), 
			      Arrays.asList("Bill", "Gates"), 
			      Arrays.asList("Mark", "Zuckerberg"));

			    List<String> namesFlatStream = namesNested.stream()
			      .flatMap(Collection::stream)
			      .collect(Collectors.toList());
			    
			    System.out.println(namesFlatStream);
		
		
			 // Skip, limit, collect
		
		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

	    List<Integer> collect = infiniteStream
	      .skip(3)
	      .limit(5)
	      .collect(Collectors.toList());
	    
	    System.out.println(collect);
	    
	    
	    //distinct()
	    
	    List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
	    List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
	    System.out.println(distinctIntList);
	    
	    intList = Arrays.asList(2, 4, 5, 6, 8);
	    
	    boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
	    boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
	    boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);
	    
	    System.out.println(allEven);
	    System.out.println(oneEven);
	    System.out.println(noneMultipleOfThree);
	    
	    
//	    intList = Arrays.asList(9, 4, 5, 6, 8);
//	    Integer latestEmpId = intList.stream()
//	    	      .mapToInt(Employee::getId)
//	    	      .max()
//	    	      .orElseThrow(NoSuchElementException::new);
	    

	}

}
