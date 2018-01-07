package com.problem.practice.dp;

public class RodCuttingProblemPrac {

	public static void main(String[] args) {
		int price[] = new int[] {1, 5, 18, 13, 10, 17, 17, 20};
		System.out.println(cutRod(price));
		System.out.println(cutRodRecursive(price, price.length));
	}

	private static int cutRodRecursive(int[] price, int length) {
		int maxPrice = 0;
		if(length < 0) {
			return 0;
		}
		for(int i = 0; i < length; i++) {
			maxPrice =  Math.max(maxPrice, price[i] + cutRodRecursive(price, length - i - 1));
		}
		return maxPrice;
	}

	private static int cutRod(int[] price) {
		
		int length = price.length;
		int[] priceVal = new int[length + 1];
		int maxPrice = 0;
		for(int i = 1; i <= length; i++) {
			for(int j = 0; j < i; j++) {
				maxPrice = Math.max(maxPrice, price[j] + priceVal[i - j - 1]);
			}
			priceVal[i] = maxPrice;
		}
		
		return maxPrice;
	}
}
