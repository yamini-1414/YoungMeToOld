package Arrays;

import java.util.Scanner;

public class KadaneAlgo {
public static int maxSum(int[] arr) {
	int maxSum = arr[0]; int sum=0;
	for(int i=0;i<arr.length;i++) {
		sum = Math.max(sum+arr[i], arr[i]);
		maxSum = Math.max(sum, maxSum);
	}
	return maxSum;
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
	    int[] a = new int[n];
	    for(int i=0;i<n;i++)
	    	a[i] = sc.nextInt();
	    System.out.println(maxSum(a));////
	}
}
}
