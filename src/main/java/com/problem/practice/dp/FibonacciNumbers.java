package com.problem.practice.dp;

public class FibonacciNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(1000));
		int n = 1000;
		int[] fib = new int[n + 1];
		System.out.println(memoizedFibonacci(n , fib));
	}
	
	public static int fibonacci(int n) {
		int[] fib = new int[n + 1];
		fib[1] = 1;
		for(int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}
	
	public static int memoizedFibonacci(int n, int[] fib) {
		if(n <= 1) {
			fib[n] = n;
		}
		if(fib[n] == 0 && n > 1) {
			//System.out.println(n);
			fib[n] = memoizedFibonacci(n - 1, fib) + memoizedFibonacci(n - 2, fib);
		}
		return fib[n];
	}

}
