package com.cts;

class MyTask implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread name: " + Thread.currentThread().getName());
	}
	
}

public class ThreadDemo {
	public ThreadDemo(){
		
	}

	public static void main(String[] args) {
		
		Runnable task = new MyTask();
		Thread t = new Thread(task);
		t.start();

	}

}
