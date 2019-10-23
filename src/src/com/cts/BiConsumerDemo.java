package com.cts;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class BiConsumerDemo {
	
	
	public static void main(String[] args) {
		
		int [] numbers = { 2,3,4,7,4};
		int operand = 2;
		
		MyBiConsumer<Integer, Integer> consumer = (x, y) -> System.out.println( x / y);
		
//		String s = "Puneet";
		
		Function<String,String> function  = (s)-> s.substring(1, 2);
//		function.apply(t)
		
		process(numbers, operand, consumer);
		
//		process(numbers, operand, wrapperLamda((x,y) -> System.out.println( x / y)));
		
//		process(numbers, operand, 
//				(x, y) -> {
//					try{
//						System.out.println( x / y);
//					}
//					catch(ArithmeticException e){
//						System.out.println(e.getMessage());
//					}
//					
//				});
		
		
	}
	
	private static BiConsumer<Integer, Integer> wrapperLamda(BiConsumer<Integer, Integer> consumer){
		return (x ,y) -> {
			try{
				consumer.accept(x, y);
			}
			catch(ArithmeticException e){
				System.out.println(e.getMessage());
			}
			
		};
	}
	
	private static void process( int [] numbers, int operand, MyBiConsumer<Integer, Integer> consumer){
		for(int n : numbers){
			consumer.accept(n, operand);
		}
	}

}

interface MyBiConsumer<T,U>{
	void accept(T t, U u);
}




