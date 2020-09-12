package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfKMostDistinct {
	 public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        // write your code here
	        if(s.length()<k) return s.length();
	        int[] count = new int[256];
	        Set<Character> window = new HashSet<Character>();
	        int maxLen = Integer.MIN_VALUE; int j=0;
	        for(int i=0;i<s.length();i++){
	            count[s.charAt(i)]++;
	            window.add(s.charAt(i));
	            while(j<s.length() && window.size()>k){
	                count[s.charAt(j)]--;
	                if(count[s.charAt(j)]==0)
	                   window.remove(s.charAt(j));
	             j++;
	            }
	            //System.out.println(s.substring(j,i+1)+" "+window.size());
	            maxLen = Math.max(maxLen,i-j+1);
	        }
	        return maxLen;
	    }
}
