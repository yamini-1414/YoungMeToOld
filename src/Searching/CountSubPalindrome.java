package Searching;

import java.util.Scanner;

public class CountSubPalindrome {
public static int countPalindromes(String s) {
	int low=0;
	int high=0; int count=0;
	int len = s.length();
	for(int i=1;i<s.length();i++) {
		//For even length palindromes centered at i or i-1
		low = i-1;
		high = i;
		while(low>=0 && high<len && s.charAt(low)==s.charAt(high)) {
			count++;
		
		--low;
		++high;
		}
		
		//For odd length palindromes centered at i
		low = i-1;
		high = i+1;
		while(low>=0 && high<len && s.charAt(low)==s.charAt(high)) {
		   count++;
		--low;
		++high;
		}
	}
	return count;
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		String str = sc.next();
		System.out.println(countPalindromes(str));
	}
}
}
