package SlidingWindow;

import java.util.Scanner;

public class FirstNegative {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		int k = sc.nextInt();
	    printMin(arr,n,k);
	}
}
static void printMin(int[] arr,int n,int k) {
    int min = -1;
	for(int i=0;i<k;i++){
	    if(arr[i]<0){
	      min= i;
	      break;
	      }
	}
	System.out.print(min==-1?0:arr[min]+" ");
	for(int i=k;i<n;i++){
	       //Now remove arr[i-k] and there is something between
	       min= -1;
	       //arr[i-k+1] .....arr[k]
	       for(int j=i-k+1;j<=i;j++){
	           if(arr[j]<0){
	           min = j;
	           break;
	           }
	       }
	       System.out.print(min==-1?0:arr[min]+" ");
	}
}
}
