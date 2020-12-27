package Arrays;

import java.util.Scanner;

public class GreaterElement {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		int max = arr[n-1];
		arr[n-1] = -1;
		for(int i = n-2;i>=0;i--) {
			int temp = arr[i];
			arr[i] = max;
			max = Math.max(max, temp);
		}
		
		for(int j=0;j<n;j++)
			System.out.print(arr[j]+" ");
		System.out.println();
	}
	
}
}
