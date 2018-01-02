package com.problem.practice.threads;

public class ProducerConsumer {

	public static void main(String[] args) {
		final Processor p = new Processor();
		
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					p.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				try {
					p.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		t1.start();
		t2.start();

	}

}
