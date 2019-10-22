package com.cts;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
	
	
	public static void main(String[] args) {
		
		int [] numbers = { 2,3,4,7,4};
		int operand = 0;
		
		
//		process(numbers, operand, (x,y) -> System.out.println( x / y));
		
		process(numbers, operand, wrapperLamda((x,y) -> System.out.println( x / y)));
		
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
	
	private static void process( int [] numbers, int operand, BiConsumer<Integer, Integer> consumer){
		for(int n : numbers){
			consumer.accept(n, operand);
		}
	}

}
