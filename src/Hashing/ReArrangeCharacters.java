package Hashing;


import java.util.HashMap;
import java.util.Scanner;

public class ReArrangeCharacters {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) 
		System.out.println(isValid(sc.next())?1:0);
}
public static boolean isValid(String s) {
	if(s.length()==0 || s.length()==1)
		return true;
	int max = Integer.MIN_VALUE;
	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	for(int i=0;i<s.length();i++) {
		char ch = s.charAt(i);
		if(map.get(ch)==null)
			map.put(ch,1);
		else {
			int x = map.get(ch);
			max = Math.max(max, x+1);
			map.put(ch, x+1);
		}
	}
	if(max>s.length()/2)
		return false;
	return true;
}
}
