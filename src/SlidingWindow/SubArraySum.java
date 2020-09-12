package SlidingWindow;

import java.util.Scanner;

public class SubArraySum 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
		    int n = sc.nextInt();
		    int target = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++)
		    	arr[i] = sc.nextInt();
		    subArraySum(arr,target);
		}
	}
public static void subArraySum(int[] arr,int target) {
	int slow= 0; int sum = 0;
	for(int fast=0;fast<arr.length;fast++) {
		sum += arr[fast];
		while(sum>= target) {
			if(sum==target) {
				System.out.println(slow+1+" "+fast+1);
				return;
			}
				sum -= arr[slow];
				slow++;
			}
		}
	}
}

