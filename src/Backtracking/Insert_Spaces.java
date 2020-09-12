package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Insert_Spaces {
	static List<String> res;
public static void recur(String s,int i,int j,int n,char[] buf) {
	if(i==n) {
		buf[j]='\0';
		System.out.println(buf);
		return;
	}
	buf[j] = s.charAt(i);
	recur(s,i+1,j+1,n,buf);
	buf[j] =' ';
	buf[j+1] = s.charAt(i);
	recur(s,i+1,j+2,n,buf);
}
public static void main(String[] args) {
	String str = "ABCD";
	char[] buf  = new char[2*str.length()];
	buf[0] = str.charAt(0);
	res  = new ArrayList<String>();
	recur(str,1,1,str.length(),buf);
	//System.out.println(res);
}
}
