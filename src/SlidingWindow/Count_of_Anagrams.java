package SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class Count_of_Anagrams {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(countAnagrams(str1,str2));
	}
}
public static int countAnagrams(String str1, String str2) {
     int[] count = new int[256];
     int n1 = str1.length();
     int n2 = str2.length();
     for(int i=0;i<n2;i++)
    	 count[str2.charAt(i)]++;
     for(int i=0;i<n2;i++)
    	 count[str1.charAt(i)]--;
     int res=0;
     if(isCount(count))
    	 res++;
     
     for(int i=n2;i<n1;i++) {
    	 count[str1.charAt(i)]--;     
         count[str1.charAt(i-n2)]++;
         
         if(isCount(count))
        	 res++;
     }
     return res;
     
}
static boolean isCount(int[] count) {
	for(int i=0;i<256;i++) {
		if(count[i]!=0)
			return false;
	}
	return true;
}
}
