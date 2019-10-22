package com.cts;

import org.omg.Messaging.SyncScopeHelper;

public class Greeter {
	
	public void greet(Greeting greeting){
		greeting.perform();
	}
	
//	public void greet(action){
//		action();
//	}
	
	public static void main(String[] args) {
		Greeter greeter  = new Greeter();
		Greeting greeting = new HelloInEnglishGreeting();
		
		
		
		
		
		Greeting greetLamda = () -> System.out.println("Hello Using Lamda");
//		FunctionType greetLamda = () -> System.out.println("Hello Using Lamda");
		
//		Runnable r = ()-> System.out.print("In a thread");
		Thread t = new Thread();
//		Interface implementation
		greeter.greet(greeting);
		
//		Anonymous class
//		System.out.println(this);
		greeter.greet(new Greeting(){
			@Override
			public void perform() {
				System.out.println("hello from anonymous class");
				System.out.println(this);
			}
		});
		
//		Lamda expression
//		System.out.println(this);
		greeter.greet(() -> {
			System.out.println("Hello Using Lamda");
//			System.out.println(this);
		});
		
		
		Thread tAnonymousClass = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("Thread running in anonymous class");
			}
			
		});
		tAnonymousClass.start();
		
		Thread tLamda = new Thread(() -> System.out.println("Thread running using lamdas "));
		tLamda.start();
		
		
		
		
//		_____Type___  functionVariable = () -> System.out.println("Hello & Good Afternoon!!");
//		MyLamda doubleNumberFunction = (int a) ->  a * 2;
		
//		FunctionType doubleNumberFunction = (a) =>  a * 2
		
				
//		addNumberFunction =  (int x, int y) -> x + y;
//		safeDivisionFunction = (int a, int b) ->  {
//			if(b == 0) return 0;
//			return a/b;
//		}
//		stringLengthCalculateFunction (String s) -> s.length();
	}
	
	
//interface MyLamda{
//	int doubleValues(int a);
////	int addValues (int a, int b);
//}

//interface MyGreetingLamda{
//	void anyMethod();
//}
	

}
