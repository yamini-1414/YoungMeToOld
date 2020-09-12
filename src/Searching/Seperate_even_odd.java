package Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Seperate_even_odd {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t=0;t<T;t++) {
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	for(int i=0;i<n;i++)
    		arr[i] = sc.nextInt();
       arrange(arr);
       System.out.println();
    }
}
public static void arrange(int[] arr) {
	int left =0; int right=arr.length-1;
	while(left<right) {
		while(arr[left]%2==0 && left<right)
			left++;
		while(arr[right]%2==1 && left<right)
			right--;
		if(left<right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	for(int i=0;i<arr.length;i++)
	  System.out.print(arr[i]+" ");
}
}
