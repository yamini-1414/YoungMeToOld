package Searching;

import java.util.Scanner;

public class LongestPalindromeLength {
	public static String longestPalindromes(String s) {
		int low=0;
		int high=0; int maxLength=0;
		int len = s.length();
		int start=0;
		for(int i=1;i<s.length();i++) {
			//For even length palindromes centered at i or i-1
			low = i-1;
			high = i;
			while(low>=0 && high<len && s.charAt(low)==s.charAt(high)) {
				if(high-low+1>maxLength) {
					start=low;
					maxLength = high-low+1;
				}
			
			--low;
			++high;
			}
			 
			//For odd length palindromes centered at i
			low = i-1;
			high = i+1;
			while(low>=0 && high<len && s.charAt(low)==s.charAt(high)) {
				if(high-low+1>maxLength) {
					start= low;
					maxLength = high-low+1;
				}
			--low;
			++high;
			}
		}
		return s.substring(start,start+maxLength);
	}

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
	    String s = sc.next();
	    System.out.println(longestPalindromes(s));
	}
}
}