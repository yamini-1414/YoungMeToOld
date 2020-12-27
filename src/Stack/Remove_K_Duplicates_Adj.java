package Stack;

import java.util.Stack;

public class Remove_K_Duplicates_Adj {
	 public String removeDuplicates(String s, int k) {
	        StringBuilder str = new StringBuilder(s);
	        Stack<Integer> st = new Stack<Integer>();
	        for(int i=0;i<str.length();i++){
	            if(i==0 || str.charAt(i)!=str.charAt(i-1))
	                st.push(1);
	            else{
	                int j = st.pop()+1;
	                if(j==k){
	                    str.delete(i-k+1,i+1);
	                    i = i-k;
	                }else
	                    st.push(j);
	            }
	        }
	     return str.toString();
	    }
}
