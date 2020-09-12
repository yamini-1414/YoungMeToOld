package DP_Problems;
import java.util.Scanner;

public class CoinChange {
	static int[] dp;
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int C = sc.nextInt();
		int n = sc.nextInt();
		int[] coins = new int[n];
		dp = new int[C+1];
		for(int i=0;i<n;i++) {
			coins[i] = sc.nextInt(); 
		}
		//System.out.println(n+" "+C);
		System.out.println(TopBottomAppr(coins,n,C));
	}
}

static int TopBottomAppr(int[] coins,int n,int C) {
	if(C==0)
		return 0;
	int min = Integer.MAX_VALUE;
	if(dp[C]!=0)
		return dp[C];
	for(int i=0;i<n;i++) {
		if(coins[i]<=C) {
	   int val = TopBottomAppr(coins,n,C-coins[i]);
	   if(val>=0 && val<min)
	      min = 1+val;
		}	
	}
	dp[C] = min==Integer.MAX_VALUE?-1:min;
	return dp[C];
}
}
