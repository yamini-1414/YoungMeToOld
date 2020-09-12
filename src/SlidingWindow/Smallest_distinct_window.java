package SlidingWindow;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Smallest_distinct_window {
  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			String str = sc.next();
			System.out.println(distinctWindow(str));
		}
	}
	
public static int distinctWindow(String str) {
     Set<Character> s = new HashSet<Character>();
     for(int i=0;i<str.length();i++)
    	 s.add(str.charAt(i));
     int[] count = new int[128];
     for(char c: s) {
    	 count[c] = 1;
     }
     int slow = 0; int cnt = 0; int min = Integer.MAX_VALUE;
    for(int fast = 0;fast<str.length();fast++) {
    	if(--count[str.charAt(fast)]>=0)
    		cnt++;
    	while(cnt==s.size()) {
    		min = Math.min(min, fast-slow+1);
    		
    		if(++count[str.charAt(slow)]>0)
    			cnt--;
    		slow++;
    	}
    }
    return min;
}
}