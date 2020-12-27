package Searching;

import java.util.Arrays;
import java.util.Scanner;

public class SumClosestToZero {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		System.out.println(sum(arr));
	}
}
public static int sum(int[] arr) {
	int i =0; int j= arr.length-1;
	int negativeSum = Integer.MIN_VALUE;
	int temp=0;
	while(i<j) {
		temp = arr[i]+arr[j];
		if(Math.abs(temp)<negativeSum)
			negativeSum = temp;
		if(temp<0)
			i++;
		else
			j--;
	}
	return negativeSum;
}
}
