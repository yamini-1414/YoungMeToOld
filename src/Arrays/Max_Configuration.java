package Arrays;

import java.util.Scanner;

public class Max_Configuration {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println(maxSum(arr));
	}
}
public static  int maxSum(int[] arr) {
	int sum = 0;
	for(int i=0;i<arr.length;i++)
		sum += arr[i];
	int curr_sum = 0;
	for(int i=0;i<arr.length;i++)
		curr_sum += i*arr[i];
	int max_sum=curr_sum;int prev_sum=curr_sum;
	for(int i=1;i<arr.length;i++) {
		curr_sum = arr[i-1]*arr.length - sum +prev_sum;
		max_sum = Math.max(max_sum, curr_sum);
		prev_sum = curr_sum;
	}
	return max_sum;
}
}
