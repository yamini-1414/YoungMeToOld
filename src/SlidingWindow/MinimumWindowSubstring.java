package SlidingWindow;

import java.util.Scanner;

public class MinimumWindowSubstring {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		String s = sc.next();
		String f = sc.next();
		System.out.println(minWindow(s,f));
	}
}
public static String minWindow(String S, String T) {
	int[] count = new int[128];
	for(int i=0;i<T.length();i++)
		count[T.charAt(i)]++;
   int slow = 0;int cnt=0; String res=""; int minLen = Integer.MAX_VALUE;
   for(int fast=0;fast<S.length();fast++) {
	   if(--count[S.charAt(fast)]>=0)
		   cnt++;
	   while(cnt==T.length()) { 
		   if(minLen>fast-slow+1) {
			   minLen = fast - slow+1;
		    res = S.substring(slow, fast+1);
		   }
		    if(++count[S.charAt(slow)]>0) {
		    	 //System.out.println(S.charAt(slow));
		  	cnt--;
		    }
		    slow++;
	   }
	   System.out.println(S.substring(slow,fast+1));
   }
   return res==""?"-1":res;
   }
}
