package Hashing;


import java.util.Arrays;
import java.util.Scanner;

public class TripletSum {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		System.out.println(isTriplet(a,sum)?1:0);
	}
}
static boolean isTriplet(int[] arr,int sum) {
	for(int i=0;i<arr.length-1;i++) {
		int j=i+1; int k = arr.length-1;
		while(j<k) {
			if(arr[i]+arr[j]+arr[k]==sum)
				return true;
			else if(arr[i]+arr[j]+arr[k]<sum)
				j++;
			else if(arr[i]+arr[j]+arr[k]>sum)
				 k--;
		}
	}
	return false;
}
}
