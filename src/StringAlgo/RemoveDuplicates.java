package StringAlgo;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveDuplicates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			String s = sc.next();
			System.out.println(removeDuplicates(s));
		}
	}
public static String removeDuplicates(String str) {
	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	String res ="";
	for(Character c:str.toCharArray()) {
		if(map.get(c)==null) {
			res += c;
			map.put(c,1);
		}
		else
			map.put(c,map.get(c)+1);
	}
	return res;
}
}
