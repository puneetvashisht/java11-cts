package com.myown;

@FunctionalInterface
interface PaymentType{
	void pay();
//	void anotherMethod();
}

@FunctionalInterface
interface CurrencyLamda{
	void print(String s);
}

class LocalPayment implements PaymentType{

	@Override
	public void pay() {
		System.out.println("Local payment in INR");
		
	}
	
}

public class Payment {
	
	public void perform(PaymentType type) {
//		System.out.println("Pay Rs. 100");
		type.pay();
	}
	
	
	public static void print(CurrencyLamda lamda) {
//		System.out.println("Pay Rs. 100");
		lamda.print("Dhiram");
	}
	
	public static void main(String[] args) {
//		1. Inherited class
		new Payment().perform(new LocalPayment());
		
//		2. Anonymous class
		new Payment().perform(new PaymentType() {

			@Override
			public void pay() {
				System.out.println("International payment IN USD");
				
			}
			
		});
//		MyLamda lamda = () -> System.out.println("International payment IN USD");
		PaymentType lamda = () -> System.out.println("International payment IN JPY");
		new Payment().perform(lamda);
		
		// Anonymous is not same as Lamda
		// Inner classes vs Lamda -- differnces
		
		// Type Inference
		CurrencyLamda cl = (s) -> System.out.println(s);
		print(cl);
		
		
		
		Thread tLamda = new Thread(() -> System.out.println("Thread running using lamdas "));
		tLamda.start();
		
		
		// Sort 
		// Print conditinally & all
		// difference in lines of codes
		
		
		
	}
	
	
}
