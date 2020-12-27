package Backtracking;
import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partition1 {
public static List<List<String>> permutatePartition(String s){
	if(s==null || s.length()==0)
		return null;
	List<List<String>> res = new ArrayList<List<String>>();
	List<String> temp = new ArrayList<String>();
	getHelper(res,temp,s,0);
	return res;
	
}
static void getHelper(List<List<String>> res,List<String> temp, String s ,int index) {
	if(index>=s.length()) {
		res.add(new ArrayList<String>(temp));
		return;
	}
	for(int i=index;i<s.length();i++) {
		if(checkPalindrome(s,index,i)) {
			temp.add(s.substring(index,i+1));
			getHelper(res,temp,s,i+1);
			temp.remove(temp.size()-1);
		}
	}
}
static boolean checkPalindrome(String s,int index,int i) {
	while(index<i) {
		if(s.charAt(index++)!=s.charAt(i--))
			return false;
	}
	return true;
}
}
