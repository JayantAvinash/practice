package com.problem.practice.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getCommonSubsequence("GXTXAYB", "AGGTAB"));
		
		System.out.println(getCommonSubsequenceDP("GXTXAYB", "AGGTAB"));
	}
	
	public static int getCommonSubsequence(String a, String b) {
		int length =  getCommonSubsequence(a, b, a.length(), b.length());
		//System.out.println(css);
		return length;
	}

	private static int getCommonSubsequence(String a, String b, int length1, int length2) {
		if(length1 == 0 || length2 == 0) {
			return 0;
		}
		if(a.charAt(length1 - 1) == b.charAt(length2 - 1)) {
			return 1 + getCommonSubsequence(a, b, length1 - 1, length2 - 1);
		} else {
			return Math.max(getCommonSubsequence(a, b, length1, length2 - 1), getCommonSubsequence(a, b, length1 - 1, length2));
		}
	}
	
	public static int getCommonSubsequenceDP(String a, String b) {
		int l1 = a.length();
		int l2 = b.length();
		int[][] arr = new int[l1 + 1][l2 + 1];
		
		for(int i = 1; i <= l1; i++) {
			for(int j = 1; j <= l2; j++) {
				if(a.charAt(i - 1) == b.charAt(j - 1)) {
					arr[i][j] = 1 + arr[i -1][j - 1];
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}
		String s = "";
		int x = l1, y = l2;
		
		while(x > 0 && y > 0) {
			if(a.charAt(x - 1) == b.charAt(y - 1)) {
				s = a.charAt(x - 1) + s;
				x--;
				y--;
			} else {
				if(arr[x - 1][y] >= arr[x][y - 1]) {
					x--;
				} else {
					y--;
				}
			}
		}
		System.out.println("Longest Common subsequence:" + s);
		return arr[l1][l2];
	}

}
