package DP_Problems;
import java.util.Scanner;

public class KnapsackProblem {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t=0;t<T;t++) {
    	int n = sc.nextInt();
    	int W = sc.nextInt();
    	int[] w = new int[n];
    	int[] val = new int[n];
        for(int i=0;i<n;i++)
        	val[i] = sc.nextInt();
        for(int i=0;i<n;i++)
        	w[i] = sc.nextInt();
        System.out.println(knapsackProb(val,w,W,n));
    }
}
public static int knapsackProb(int[] val,int[] w,int W,int n) {
	int[][] t = new int[n+1][W+1];
	for(int i=0;i<=n;i++) {
		for(int j=0;j<=W;j++) {
			if(i==0 || j==0)
				t[i][j] = 0;
			else if(w[i-1]<=j) {
				t[i][j] = Math.max(val[i-1]+t[i-1][j-w[i-1]], t[i-1][j]);
			}else {
				t[i][j] = t[i-1][j];
			}
		}
	}
	return t[n][W];
}
}
