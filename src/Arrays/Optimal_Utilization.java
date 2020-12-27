package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Optimal_Utilization {
public static void main(String[] args) {
	List<List<Integer>> a = new ArrayList<List<Integer>>();
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	Collections.sort(a,(p,q)->p.get(1)-q.get(1));
	
	a.add(Arrays.asList(1,3));
	a.add(Arrays.asList(2,5));
	a.add(Arrays.asList(3,7));
	a.add(Arrays.asList(4,10));
	List<List<Integer>> b = new ArrayList<List<Integer>>();
	Collections.sort(b,(p,q)->p.get(1)-q.get(1));
	
	b.add(Arrays.asList(1,2));
	b.add(Arrays.asList(2,3));
	b.add(Arrays.asList(3,4));
	b.add(Arrays.asList(4,5));
	int target = 10; int maxSum=Integer.MIN_VALUE;
    int m = a.size();
    int n = b.size();
    System.out.println(m+" "+n);
    int i=0; int j= n-1; int max_i=0; int max_j=0;
    while(i<m && j>=0) {
    	int sum = a.get(i).get(1)+b.get(j).get(1);
    	System.out.println(a.get(i).get(1)+ " "+b.get(j).get(1));
    	if(sum>target)
    		j--;
    	else if(sum<=target) {
    		if(sum>maxSum) {
    			maxSum = sum;
                res.clear();
    		}
    		res.add(Arrays.asList(a.get(i).get(0),b.get(j).get(0)));
    	}
    	i++;
    }
    //res.add(Arrays.asList(max_i,max_j));
	System.out.println(res);
	
}
}
