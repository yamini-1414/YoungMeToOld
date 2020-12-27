package Arrays;

import java.util.Scanner;

public class Equibrium_point {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++ ) {
		int n = sc.nextInt();
		int sum=0; int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int index=-1;
		int currSum=0;
		for(int i=0;i<n;i++) {
			currSum += arr[i];
			if(sum - 2*currSum ==arr[i]) {
				index = i; break;
			}
		}
		System.out.println(index);
	}
	
}
}
