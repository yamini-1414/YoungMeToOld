package Searching;

import java.util.Scanner;

public class Search_in_matrix {
public static int search(int[][] arr,int m,int n,int data) {
    int i=0;int j=n-1;
    while(j>=0 && i<m) {
    	if(arr[i][j]==data)
    			return 1;
    	if(arr[i][j]<data)
    		  i++;
    	else if(arr[i][j]>data) {
    		j--;
    		i=0;
    	}
     }
    return 0;
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] a = new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				a[i][j] = sc.nextInt();
		int data = sc.nextInt();
		System.out.println(search(a,m,n,data));
	}
}
}
