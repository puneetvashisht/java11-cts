package com.cts;

public class ClosureDemo {
	
	public static void main(String[] args) {
		
		int a = 33;
		
		for(int i=0 ; i<5 ; i++){
			Thread t = new Thread(()->  System.out.println("Runs in a thread: " + a  + " ~ " + Thread.currentThread().getName()) );
			t.start();
		}
		
		System.out.println("Main thread");
		
		
	}

}
