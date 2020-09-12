package DP_Problems;
import java.util.Scanner;

public class LIS {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println(lis(arr,n));
	}
}
public static int lis(int[] arr,int n) {
	int[] l = new int[n];
	for(int i=0;i<n;i++) {
		for(int j=0;j<i;j++) {
			if(arr[i]>arr[j] && l[i]<l[j]+1)
				l[i] = l[j]+1;
		}
	}
     int max = Integer.MIN_VALUE;
     for(int i=0;i<n;i++)
    	 max = Math.max(max, l[i]);
     return max+1;
}
}
