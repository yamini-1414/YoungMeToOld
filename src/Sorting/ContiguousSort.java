package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class ContiguousSort {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println(sort(arr)?"Yes":"No");
	}
}
public static boolean sort(int[] arr) {
	Arrays.sort(arr);
	for(int i=0;i<arr.length-1;i++) {
		if(arr[i]!=arr[i+1]) {
			if(arr[i+1] != arr[i]+1)
				  return false;
		}
	}
	return true;
}
}
