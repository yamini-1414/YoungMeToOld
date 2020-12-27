package Searching;

import java.util.Arrays;
import java.util.Scanner;

public class FourSum {
public static void fourSum(int[] arr,int k) {
	Arrays.sort(arr);
	int left; int right;boolean flag = false;
	for(int i=0;i<arr.length-3;i++) {
		for(int j=i+1;j<arr.length-2;j++) {
			left = j+1;
			right = arr.length-1;
			while(left<right) {
				 if(arr[i]+arr[j]+arr[left]+arr[right]==k) {
					 flag = true;
					 System.out.print(arr[i]+" "+arr[j]+" "+arr[left]+" "+arr[right]+" $");
					 left++;
					 right--;
				 }
				 else if(arr[i]+arr[j]+arr[left]+arr[right]<k)
					               left++;
				 else
					 right--;
			} 
		}
	}
	if(!flag)
		System.out.print("-1");
	System.out.println();
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		fourSum(arr,k);
	}
	
}
}
