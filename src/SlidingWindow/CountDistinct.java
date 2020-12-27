package SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class CountDistinct {
public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   int T = sc.nextInt();
   for(int t=0;t<T;t++){
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] arr = new int[n];
      for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();
     countDistinct(arr,n,k);
   }
}
public static void countDistinct(int[] arr,int n,int k){
    int dist = 0;
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    for(int i=0;i<k;i++) {
          if(map.get(arr[i])==null) {
        	  dist++;
        	  map.put(arr[i],1);
          }else 
        	  map.put(arr[i],map.get(arr[i])+1);
    }
    System.out.print(dist+" ");
       for(int i=k;i<n;i++) {
    	   if(map.get(arr[i-k])==1) {
    		   dist--;
    		   map.remove(arr[i-k]);
    	   }else
    		   map.put(arr[i-k], map.get(arr[i-k])-1);
    	   if(map.get(arr[i])==null) {
         	  dist++;
         	  map.put(arr[i],1);
           }else 
         	  map.put(arr[i],map.get(arr[i])+1);
    	System.out.print(dist+" ");
     }
}
}