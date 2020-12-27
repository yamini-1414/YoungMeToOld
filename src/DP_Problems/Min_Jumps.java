package DP_Problems;

import java.util.Arrays;
import java.util.Scanner;

public class Min_Jumps {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++)
		    arr[i] = sc.nextInt();
		    System.out.println(minJumpsDP(arr));
		}
	}
	public static int minJumps(int[] arr){
	    if(arr[0]==0) return -1;
	    int maxReached= 0; int jumps=0; int steps = 0;
	    for(int i=0;i<arr.length-1;i++){
	        maxReached = Math.max(maxReached, i+arr[i]);
	        if(i==steps){
	            jumps++;
	            if(i>=maxReached) return -1;
	            steps = maxReached;
	        }
	    }
	    return jumps;
	}
	public static int minJumpsDP(int[] arr){
	    if(arr[0]==0) return -1;
	    int[] dp = new int[arr.length];
	    Arrays.fill(dp,Integer.MAX_VALUE);
	    dp[0] = 0;
	    for(int i=1;i<arr.length;i++){
	        for(int j=0;j<i;j++){
	            if(i<=j+arr[j] && dp[j] != Integer.MAX_VALUE)
	              dp[i] = Math.min(dp[i],dp[j]+1);
	        } 
	    }
	    int n  = arr.length;
	    return dp[n-1]==Integer.MAX_VALUE?-1: dp[n-1];
	}
}
