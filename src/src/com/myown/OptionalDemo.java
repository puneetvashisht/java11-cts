package com.myown;

import java.util.Optional;

 class Person {
    private String name;
    private int age;
    private String password;
 
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
 
    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }
 
    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
    
    
 
    // normal constructors and setters
}

public class OptionalDemo {
	
	

	
	

	public static void main(String[] args) {
		
//		To create an empty Optional object,
		 Optional<String> empty = Optional.empty();
		 System.out.println(empty.isPresent());
		 
		 String name = "puneet";
		 Optional<String> opt = Optional.of(name);
		 System.out.println(opt.isPresent());
		 //Works opposite of isPresent in Java 11
//		 System.out.println(opt.isEmpty());
		 
//		 in case we expect some null values, we can use the ofNullable()
		 name=null;
//		 Optional<String> opt1 = Optional.of(name);
		 Optional<String> opt1 = Optional.ofNullable(name);
		 System.out.println(opt1.isPresent());
		 
		 
//		 Avoid NullPointerException
		 opt1.ifPresent(n -> System.out.println(n.length()));
		 
		 
//		 orElseGet() method is similar to orElse(), former takes functional interface
		 String name1 = Optional.ofNullable(name).orElse("Vashisht");
		 String name2 = Optional.ofNullable(name).orElseGet(() -> "Vashisht");
		 
		 // throw exception instead of returning default value
//		 String name3 = Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);
		 
		 // get method
		 String name4 = opt.get();
		 System.out.println(name4);
		 
		 
//		 Conditional Return With filter()
		 Integer year = 2016;
		    Optional<Integer> yearOptional = Optional.of(year);
		    boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
		    System.out.println(is2016);
		    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
		    System.out.println(is2017);
		    
//		    Filter with map
		    String password = " password ";
		    Optional<String> passOpt = Optional.of(password);
		    boolean correctPassword = passOpt.filter(
		      pass -> pass.equals("password")).isPresent();
		    System.out.println(correctPassword);
		 
		    correctPassword = passOpt
		      .map(String::trim)
		      .filter(pass -> pass.equals("password"))
		      .isPresent();
		    System.out.println(correctPassword);
		    
		    
		    // Flat Map
		    Person person = new Person("john", 26);
		    Optional<Person> personOptional = Optional.of(person);
		 
		    Optional<Optional<String>> nameOptionalWrapper  
		      = personOptional.map(Person::getName);
		    Optional<String> nameOptional  
		      = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
		    String name6 = nameOptional.orElse("");
		    System.out.println(name6);
		 
		    String name5 = personOptional
		      .flatMap(Person::getName)
		      .orElse("");
		    System.out.println(name5);

	}

}
