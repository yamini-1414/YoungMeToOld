package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class DivideArray {
	static List<List<Integer>> res;
public static void main(String[] args) {
	int[] arr = {1,2,3,3,4,4,5,6};
	res = new ArrayList<List<Integer>>();
	List<Integer> curr = new ArrayList<Integer>();
	recur(arr,4,arr.length-1,0,curr);
	System.out.println(res);
}
public static void recur(int[] arr,int k,int n,int l,List<Integer> curr) {
	if(curr.size()==k) {
		res.add(new ArrayList<Integer>(curr));
		curr = new ArrayList<Integer>();
		l++;
	}
	for(int i=l;i<n;i++) {
		if(arr[i]+1==arr[i+1]) {
			curr.add(arr[i]);
			//System.out.println(curr);
			recur(arr,k,n,i+1,curr);
			curr.remove(curr.size()-1);
		}
	}
}
}
