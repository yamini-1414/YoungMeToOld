package StringAlgo;

import java.util.*;
public class GroupAnagrams {
public static void main(String[] args) {
		String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(countAnagrams(str));
	}
public static List<List<String>> countAnagrams(String[] str) {
    List<List<String>> res = new  ArrayList<List<String>>();
    HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    List<String> r = new ArrayList<String>() ;
	for(int i=0;i<str.length;i++) {
		char[] c = str[i].toCharArray();
		Arrays.sort(c);
	    String s = new String(c);
		if(map.containsKey(s))
	         r = map.get(s);
		else
			 r = new ArrayList<String>();
		r.add(str[i]);
		map.put(s,r);
	}
     for(String s: map.keySet()) 
		res.add(new ArrayList<String>(map.get(s)));
     return res;
}


}
