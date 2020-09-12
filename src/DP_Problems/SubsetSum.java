package DP_Problems;

import java.util.Scanner;

public class SubsetSum {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		int sum= 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		if(sum%2!=0)
			System.out.println("NO");
		else {
			int target= sum/2;
			boolean[] dp = new boolean[target+1];
			dp[0] = true;
			for(int num:arr) {
				for(int k=target;k>=num;k--)
					dp[k]= dp[k] || dp[k-num];
			}
			if(dp[target])
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		    
	}
}
}
