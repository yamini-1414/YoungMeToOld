package Searching;

import java.util.Scanner;

public class Median_same_length {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		for(int i=0;i<n;i++)
			b[i] = sc.nextInt();
		System.out.println(getMedian(a,0,n-1,b,0,n-1));
	}
}
public static int  getMedian(int[] a,int a_start,int a_end,int[] b,int b_start,int b_end) {
    if (a_end-a_start<= 0 && b_end-b_start<=0)  
        return -1;  
    if (a_end-a_start==1 && b_end-b_start==1)  
        return (a[0] + b[0]) / 2;  

	if(a_end-a_start+1==2 && b_end-b_start+1==2) {
		int p = Math.max(a[a_start], b[b_start]);
		int q = Math.min(a[a_end], b[b_end]);
		System.out.println(p+ " "+q);
		return (p+q)/2;
	}
	
	float median_a = median(a,a_start,a_end);
	float median_b = median(b,b_start,b_end);
	System.out.println(median_a + " "+median_b);
	int mid_a = (a_start+a_end)/2;
	int mid_b = (b_start+b_end)/2;
	if(median_a==median_b)
		return (int)median_a;
	if(median_a<median_b)
		return getMedian(a,mid_a,a_end,b,b_start,mid_b);
	else
	   return getMedian(a,a_start,mid_a,b,mid_b,b_end);
		
}
public static float  median(int[] a,int start,int end) {
	int len = end-start+1;
	if(len%2==0) {
		return ((a[start+len/2]+a[start+len/2-1])/2);
	}else
        return (a[(start+end)/2]);
}
}
