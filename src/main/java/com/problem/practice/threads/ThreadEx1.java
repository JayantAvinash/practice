package com.problem.practice.threads;

public class ThreadEx1 {
	
	public static void main(String[] args) {
		Runner r = new Runner();
		r.start();
		
		Runner r1 = new Runner();
		r1.start();

	}

}

class Runner extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Hello:" + i);
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
