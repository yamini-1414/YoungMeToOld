package StringAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Largest_in_array {
public static class StringComparator implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg1.length()-arg0.length();
	}
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		String[] str = new String[n];
		for(int i=0;i<n;i++)
			str[i] = sc.next();
		String pattern = sc.next();
		Arrays.sort(str,new StringComparator());
		System.out.println(findPattern(str,pattern));
	}
}
public static String findPattern(String[] str, String pattern) {
	ArrayList<Character> r = new ArrayList<Character>();
	for(Character c: pattern.toCharArray())
		r.add(c);
	String res="";
	for(String s: str) {
		  boolean flag = false;
		for(Character ch: s.toCharArray()) {
			if(!r.contains(ch))
				flag=true;
		}
		
	    if(!flag) { res = s; break;}	
	    
	}
	return res;
}
}

