package StringAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class SecondRepeat {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		String[] str =new String[n];
		for(int i=0;i<n;i++)
			str[i] = sc.next();
		System.out.println(secondRepeat(str));
	}
}
public static String secondRepeat(String[] str) {
	HashMap<String,Integer> map = new HashMap<String, Integer>();
	for(String s: str) {
		if(map.get(s)==null)
			map.put(s,1);
		else
			map.put(s,map.get(s)+1);
	}
	System.out.println(map);
	ArrayList<Integer> res = new ArrayList<Integer>();
	for(String s:map.keySet())
	   res.add(map.get(s));
	Collections.sort(res,Collections.reverseOrder());
	String sec="";
	for(String s: map.keySet()) {
		if(map.get(s)==res.get(1))
			sec = s;
	}
	return sec;
}

}
