package SlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

public class SubArray_Zero_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			System.out.println(findSumZero(arr)?"Yes":"No");
		}
	}
	
	public static boolean findSumZero(int[] arr) {
		ArrayList<Integer> map = new ArrayList<Integer>();
		int sum=0; 
		map.add(0);
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
			if(map.contains(sum))
				return true;
			else
				map.add(sum);
		}
		return false;
	}
}
