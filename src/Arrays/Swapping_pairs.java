package Arrays;

import java.util.Scanner;

public class Swapping_pairs {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		int sum1 = 0; int sum2=0;
		for(int i=0;i<n1;i++) {
			arr1[i] = sc.nextInt();
			sum1 += arr1[i];
		}
		for(int i=0;i<n2;i++) {
			arr2[i] = sc.nextInt();
			sum2 += arr2[i];
		}
		boolean flag = false;
		for(int i=0;i<Math.min(n1, n2);i++) {
			if((sum1-sum2)/2 == (arr1[i]-arr2[i])) {
				flag= true; break;
			}
		}
		System.out.println(flag?"1":"0");
	}
}
}
