package Searching;

import java.util.ArrayList;

public class BeautifulArray {
public static void beautifulArray(int n) {
    ArrayList<Integer> temp = new ArrayList<Integer>();
    temp.add(1);
    while(temp.size()<n) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	for(int i: temp) if(i*2-1<=n)res.add(i*2-1);
    	for(int i: temp) if(i*2<=n) res.add(i*2);
    	//System.out.println(res);
    	temp = res;
    }
    System.out.println(temp);
}
public static void main(String[] args) {
	beautifulArray(6);
}
}
