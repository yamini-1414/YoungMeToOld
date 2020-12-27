package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithK {
public static int subArraysK(int[] arr,int K) {
	if(arr.length==0) return 0;
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	int j =0; int total=0;int dist=0;
	for(int i=0;i<arr.length;i++) {
		if(map.get(arr[i])==null) {
			dist++;
			map.put(arr[i],1);
		}else
			map.put(arr[i],map.get(arr[i])+1);
		
		while(dist>K) {
			if(map.get(arr[j])==1) {
				dist--;
				map.remove(arr[j]);
			}else
				map.put(arr[j],map.get(arr[j])-1);
			j++;
		}
		total+=i-j+1;
	}
	return total;
}
public static void main(String[] args) {
	int[] arr = {1,2,1,2,3};
	System.out.println(subArraysK(arr,1));
}
}
