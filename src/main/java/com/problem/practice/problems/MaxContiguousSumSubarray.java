package com.problem.practice.problems;

public class MaxContiguousSumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr =  {-2, -3, 4, -1, -2, 1, 5, -3, 4};
		getMaxContiguousSubarray(arr);
	}
	
	public static void getMaxContiguousSubarray(int[] arr) {
		int minIndex = 0;
		int maxIndex = 0;
		int currMinIndex = 0;
		//int currMaxIndex = 0;
		int sum = 0;
		int prevPositiveSum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		//	currMaxIndex = i;
			if(prevPositiveSum < sum) {
				maxIndex = i;
				if(currMinIndex != minIndex) {
					minIndex = currMinIndex;
				}
				prevPositiveSum = sum;
			}
			if(sum < 0) {
				sum = 0;
				currMinIndex = i + 1;
			}
		}
		System.out.println("Max sum : " + prevPositiveSum);
		System.out.println("Min Index: " + minIndex);
		System.out.println("Max Index: " + maxIndex);
		
		System.out.println("Min Index: " + currMinIndex);
		//System.out.println("Max Index: " + currMaxIndex);
		
	}

}
