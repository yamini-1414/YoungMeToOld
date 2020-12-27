package StringAlgo;

import java.util.Scanner;

public class Form_a_palindrome {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		String s = sc.next();
		System.out.println(minInsertions(s));
	}
}
public static int minInsertions(String str) {
	int n = str.length();
	int[][] T = new int[n][n];
	
	for(int len=1;len<n;len++) {
		for(int l=0,h=len;h<n;l++,h++) {
			if(str.charAt(l)==str.charAt(h))
				T[l][h] = T[l+1][h-1];
			else
				T[l][h] =1+ Math.min(T[l+1][h], T[l][h-1]);
		}
	}
	return T[0][n-1];
}
}
