package DP_Problems;
import java.util.Scanner;

public class LCS {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int m = sc.nextInt();
		int n = sc.nextInt();
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.println(lcs(m,n,str1,str2));
	}
}
public static int lcs(int m,int n, String str1,String str2) {
	if(m==0 || n==0)
		return 0;
	int[][] T = new int[m+1][n+1];
	
	for(int i=0;i<m;i++) {
		for(int j=0;j<n;j++) {
			if(str1.charAt(i)==str2.charAt(j))
				//It is previous +1
				T[i+1][j+1] = T[i][j]+1;
			else
				// think whether to remove character in str1 or str2
				T[i+1][j+1] = Math.max(T[i][j+1], T[i+1][j]);
		}
	}
	return T[m][n];
}
}
