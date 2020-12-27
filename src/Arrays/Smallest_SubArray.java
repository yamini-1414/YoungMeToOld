package Arrays;

import java.util.Scanner;

public class Smallest_SubArray {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println(smallestWindow(arr,x));
	}
}
public static int smallestWindow(int[] arr,int x) {
	int minLen= Integer.MAX_VALUE; int slow = 0; int sum=0;
	for(int fast=0;fast<arr.length;fast++) {
		sum += arr[fast];
		while(sum>x) {
			minLen = Math.min(minLen, fast-slow+1);
			sum -= arr[slow];
			slow++;
		}
	}
	return minLen;
}
}
