package com.problem.practice.threads;

import java.util.LinkedList;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	
	private int LIMIT = 10;
	
	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (this) {
				
				while(list.size() == LIMIT) {
					this.wait();
				}
				
				list.add(value++);
				this.notify();
			}
		}
		
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized (this) {
				while(list.size() == 0) {
					this.wait();
				}
				
				System.out.print("Size of List: " + list.size());
				int value = list.removeFirst();
				System.out.println("; Value Removed: " + value);
				this.notify();
				
			}
			Thread.sleep(100);
		}
	}
	
}
