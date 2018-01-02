package com.problem.practice.dp;

public class RodCuttingProblem {

	public static void main(String[] args) {
		int price[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(cutRod(price));
		System.out.println(cutRodRecursive(price, price.length));

	}

	private static int cutRod(int[] price) {
		int length = price.length;
		int[] max = new int[length + 1];
		int maxVal = 0;
		for(int i = 1; i <= length; i++) {
			for(int j = 0; j < i; j++) {
				maxVal = Math.max(maxVal, price[j] + max[i - j - 1]);
			}
			max[i] = maxVal;
		}
		return maxVal;
	}
	
	private static int cutRodRecursive(int[] price, int length) {
		if(length <= 0) {
			return 0;
		}
		int maxVal = 0;
		for(int i = 0; i < length; i++) {
			maxVal = Math.max(maxVal, price[i] + cutRodRecursive(price, length - i - 1));
		}
		return maxVal;
	}

}
