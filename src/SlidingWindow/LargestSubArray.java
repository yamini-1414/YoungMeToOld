package SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArray {
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int t=0;t<T;t++) {
    		int n = sc.nextInt();
    		int target = sc.nextInt();
    		int[] arr = new int[n];
    		for(int i=0;i<n;i++)
    		  arr[i] = sc.nextInt();
    		System.out.println(maxLength(arr,target));
    	}
    }
public static int maxLength(int[] arr,int target) {
	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    map.put(0, -1);
    int sum = 0; int maxLen = Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++) {
    	sum += arr[i];
    	if(map.containsKey(sum-target)) {
    		maxLen = Math.max(maxLen, i-map.get(sum-target));
    	}
    	  if(map.get(sum)==null)
    		map.put(sum,i);
    }
    return  maxLen ==Integer.MIN_VALUE?0:maxLen;
    
}
}
