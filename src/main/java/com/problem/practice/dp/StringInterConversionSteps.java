package com.problem.practice.dp;

//3 operations allowed
//insert, remove or replace
public class StringInterConversionSteps {
	
	/*If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings. 
	 * So we recur for lengths m-1 and n-1.
	Else (If last characters are not same), we consider all operations on ‘str1’, consider all three operations on last character 
	of first string, recursively compute minimum cost for all three operations and take minimum of three values.
	Insert: Recur for m and n-1
	Remove: Recur for m-1 and n
	Replace: Recur for m-1 and n-1*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "saturday";
		String s2 = "sunday";
		
		System.out.println(getConvertSteps(s1, s2, s1.length(), s2.length()));
		
		System.out.println(getConvertSteps(s1, s2));
		
	}
	
	public static int getConvertSteps(String a, String b, int l1, int l2) {
		if(l1 == 0) {
			return l2;
		}
		if(l2 == 0) {
			return l1;
		}
		
		if(a.charAt(l1 - 1) == b.charAt(l2 - 1)) {
			return getConvertSteps(a, b, l1 - 1, l2 - 1);
		}
		
		return 1 + Math.min(getConvertSteps(a, b, l1, l2 - 1), Math.min(getConvertSteps(a, b, l1 - 1, l2),
				getConvertSteps(a, b, l1 - 1, l2 - 1)));
	}
	
	public static int getConvertSteps(String a, String b) {
		int l1 = a.length();
		int l2 = b.length();
		
		int[][] arr = new int[l1 + 1][l2 + 1];
		
		for(int i = 0; i <= l1; i++) {
			for(int j = 0; j <= l2; j++) {
				if(i == 0) {
					arr[i][j] = j;
				} else if (j == 0) {
					arr[i][j] = i;
				} else if(a.charAt(i - 1) == b.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1];
				} else {
					arr[i][j] = 1 + Math.min(arr[i -1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1]));
				}
			}
		}
		return arr[l1][l2];
	}

}
