package Sorting;

import java.util.Scanner;

public class Sort0_1_2 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		sort(arr);
	}
}
static void sort(int[] arr) {
   int k= 3;
   int n = arr.length;
   int[] count = new int[k];
   for(int i=0;i<n;i++)
	   count[arr[i]]++;
   
   for(int i=0;i<k;i++) {
	   int temp = count[i]; 
	   while(temp>0) {
		   System.out.print(i+" ");
		   temp--;
	   }
   }
   System.out.println();
}
}
