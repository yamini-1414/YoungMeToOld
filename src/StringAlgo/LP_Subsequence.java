package StringAlgo;

import java.util.Scanner;

public class LP_Subsequence {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		String str = sc.next();
		System.out.println(lps(str));
	}
}
public static int lps(String str) {
	int n = str.length();
	int[][] T = new int[n][n];
	for(int i=0;i<n;i++) {
		T[i][i] = 1;
	}
    for(int len=1;len<n;len++) {
    	for(int l=0,h=len;h<n;l++,h++) {
    		if(str.charAt(l)==str.charAt(h))
    			T[l][h] = T[l+1][h-1]+2;
    		else
    			T[l][h] = Math.max(T[l+1][h], T[l][h-1]);
    	}
    } 
    return T[0][n-1];
}
//Subsequence gives the string after removing the unnecessary characters
//Inorder to obtain the deleted characters, subtract the length - subsequence length;
public static int minDeletions(String str) {
	return str.length()-lps(str);
}
}