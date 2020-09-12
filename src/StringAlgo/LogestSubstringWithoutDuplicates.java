package StringAlgo;

import java.util.HashMap;

public class LogestSubstringWithoutDuplicates {
	 public int lengthOfLongestSubstring(String s) {
	        if(s==null || s.length()==0)
	            return 0;
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        int slow=0; int max = 0;  int n = s.length();
	        for(int fast=0;fast<n;fast++){
	            if(map.containsKey(s.charAt(fast))){
	               slow = Math.max(map.get(s.charAt(fast)),slow);
	            }
	                max = Math.max(max,fast-slow+1);
	                map.put(s.charAt(fast),fast+1);
	            
	        }
	        return max;
	    }
}
