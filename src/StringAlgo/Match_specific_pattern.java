package StringAlgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Match_specific_pattern {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int  T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		ArrayList<String> res = new ArrayList<String>();
		for(int i=0;i<n;i++) 
			res.add(sc.next());
	    String pattern = sc.next();
	    System.out.println(findMatchedWords(res,pattern));
	}
}
public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
{
	 ArrayList<String> res = new ArrayList<String>();
	    String hash = encodeString(pattern);
	    for(int i=0;i<dict.size();i++){
	        if(encodeString(dict.get(i)).equals(hash))
	           res.add(dict.get(i));
	    }
	    return res;
}
public static String encodeString(String str) {
	String res=""; int index = 0;
	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
     for(int i=0;i<str.length();i++) {
    	 if(!map.containsKey(str.charAt(i)))
    		 map.put(str.charAt(i),index++);
    	 res += map.get(str.charAt(i));
     }
     return res;
}

}
