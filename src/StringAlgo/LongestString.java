package StringAlgo;

import java.util.HashSet;
import java.util.Scanner;

public class LongestString {
public static int maxString(String s) {
	if(s.length()==0)
		return 0;
	HashSet<Character> set = new HashSet<Character>();
	int max_len=0;
	int i=0;int j=0;
	while(j<s.length()) {
	   if(!set.contains(s.charAt(j))) {
		   set.add(s.charAt(j));
		   j++;
		   max_len = Math.max(max_len,j-i);
	   }else {
		   set.remove(s.charAt(i));
		   i++;
	   }
	}
	return max_len;
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		String str = sc.next();
		System.out.println(maxString(str));
	}
}
}
