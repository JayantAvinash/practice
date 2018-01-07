package com.problem.practice.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 22, 9, 33, 21, 50, 60, 41, 60 };
		System.out.println(lis(arr));
		System.out.println(getLisDynamic(arr));
	}
	
	public static int lis(int arr[]) {
		int maxLength = 1;
		return lis(arr, arr.length, maxLength);
	}

	private static int lis(int[] arr, int length, int maxLength) {
		int maxVal=1 , maxRes;
		
		if(length == 1) {
			return 1;
		}
		for(int i = 1; i < length; i++) {
			maxRes = lis(arr, i, maxLength);
			if(arr[i - 1] < arr[length - 1] && maxRes + 1 > maxVal) {
				maxVal = maxRes + 1;
			}
		}
		if(maxLength < maxVal) {
			maxLength = maxVal;
		}
		return maxLength;
		
	}
	
	public static int getLisDynamic(int[] arr) {
		int length = arr.length;
		int[] lis = new int[length];
		for(int i = 0; i < length; i++) {
			lis[i] = 1;
		}
		int max = 0;
		for(int i = 1; i < length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && lis[j] + 1 > lis[i]) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		for(int i = 0; i < length; i++) {
			max = Math.max(max, lis[i]);
			System.out.println(lis[i]);
		}
		
		return max;
	}
}
