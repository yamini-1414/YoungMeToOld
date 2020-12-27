package Searching;

import java.util.Scanner;

public class FloorArray {
public static int  getFloor(int[] arr,int data) {
	int left =0;
	int right = arr.length-1;
	int mid=0;
	while(left<=right) {
		mid = (left+right)/2;
		if(mid+1<arr.length &&arr[mid]<=data && arr[mid+1]>data)
			return mid;
		if(mid-1>=0 && arr[mid]>data && arr[mid-1]<data)
			return mid-1;
		if(arr[mid]<data)
			left = mid+1;
		else 
			right = mid-1;
	}
	if(data>=arr[mid])
		return mid;
	return -1;
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
		System.out.println(getFloor(arr,k));
	}
		
}
}
