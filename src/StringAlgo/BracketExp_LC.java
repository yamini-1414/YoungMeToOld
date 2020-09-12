package StringAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BracketExp_LC {
	static List<List<Character>> res;
	static List<String> result;
public static String[] expand(String S) {
	List<Character> temp  = new ArrayList<Character>();
	res = new ArrayList<List<Character>>();
	boolean start = false;
	for(int i=0;i<S.length();i++) {
		if(S.charAt(i)==',')
			continue;
		if(S.charAt(i)=='{') {
			start= true;
			temp = new ArrayList<Character>();
			continue;
		}
		if(S.charAt(i)=='}') {
			start= false;
			res.add(temp);
			continue;
		}
		if(start)
			temp.add(S.charAt(i));
		else
			res.add(Arrays.asList(S.charAt(i)));
	}
	System.out.println(res);
	result = new ArrayList<String>();
	getString(0,"");
	int index=0;
	String[] r = new String[result.size()];
	for(String s: result)
		r[index++] = s;
	return r;
	
	
}
public static void getString(int index, String s) {
	if(index==res.size()) {
		 result.add(s);
		 return;
	}
	
	List<Character> temp = res.get(index);
	for(Character ch:temp)
		getString(index+1,s+ch);
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String S = "{a,b}c{d,e}f";
	 String[] exp = expand(S);
	System.out.println("sjdbjs");
}
}
