package SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArray_0_1 {
        public static void main(String[] args) {
        	Scanner sc = new Scanner(System.in);
        	int T = sc.nextInt();
        	for(int t=0;t<T;t++) {
        		int n = sc.nextInt();
        		int[] arr = new int[n];
        		for(int i=0;i<n;i++)
        		  arr[i] = sc.nextInt();
        		System.out.println(maxLength(arr));
        	}
        }
	public static int maxLength(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    map.put(0, -1);
	    int sum = 0; int maxLen = Integer.MIN_VALUE;
	    for(int i=0;i<arr.length;i++) {
	    	sum += arr[i]==0?-1:+1;
	    	if(map.containsKey(sum)) {
	    		maxLen = Math.max(maxLen, i-map.get(sum));
	    	}
	    	else
	    		map.put(sum,i);
	    }
	    return maxLen;
	    
	}
}
