package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeating {

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		String str = sc.next();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<n;i++) {
			if(map.containsKey(str.charAt(i)))
				map.put(str.charAt(i),map.get(str.charAt(i))+1);
			else
				map.put(str.charAt(i),1);
		}
		char res='-';
		for(int j=0;j<str.length();j++) {
			if(map.get(str.charAt(j))==1) {
				res = str.charAt(j);
				break;
			}
		}
		System.out.println(res=='-'?"-1":res);
	}
}
}
