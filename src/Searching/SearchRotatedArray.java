package Searching;

import java.util.Scanner;

public class SearchRotatedArray {
	public static void main (String[] args) {
		   Scanner sc = new Scanner(System.in);
		   int T = sc.nextInt();
		   for(int t=0;t<T;t++){
		       int n = sc.nextInt();
		       int[] arr = new int[n];
		       for(int i=0;i<n;i++)
		         arr[i] = sc.nextInt();
		       int k = sc.nextInt();
		       System.out.println(search(arr,k));
		   }
		}
		public static int search(int[] arr,int data){
		    int left = 0;
		    int right = arr.length-1;
		    while(left<=right) {
		    	int mid = (left+right)/2;
		    	System.out.println(arr[mid]+" ");
		    	if(arr[mid]==data)
		    		return mid;
		    	if(arr[left]<=arr[mid]) {
		    		     if(data >=arr[left] && data<arr[mid]) { 
		    		    	    right = mid-1;
		    		     }
		    		     else
		    		    	 left = mid+1;
		    	}else if(arr[left]>arr[mid]) {
		    		if(data>=arr[mid] && data<=arr[right])
		    			     left = mid+1;
		    		else
		    			    right = mid-1;
		    	}
		    }
		    return -1;
		}
		public static int findMin(int[] arr) {
			int left=0;
			int right = arr.length-1;
			int mid=0;
			while(left<right) {
				mid = (left+right)/2;
				if(mid<right && arr[mid+1]<arr[mid])
					   return arr[mid+1];
				if(mid>left && arr[mid-1]>arr[mid])
					return arr[mid];
			    if(arr[left]<arr[mid])
			    	left = mid+1;
			    else if(arr[mid]<arr[right])
			    	right = mid-1;
			}
			return arr[0]; //When the list is sorted , first is the minimum
		}
		public static int findMax(int[] arr) {
			int left=0;
			int right = arr.length-1;
			int mid=0;
			while(left<right) {
				mid = (left+right)/2;
				// Case when mid is the maximum element  4 5 6 7 1 2 3
				if(mid<right && arr[mid+1]<arr[mid])
					   return arr[mid];
				//Case when mid-1 is the maximum element 4 5 1 2 3
				if(mid>left && arr[mid-1]>arr[mid])
					return arr[mid-1];
			    if(arr[left]<arr[mid])
			    	left = mid+1;
			    else if(arr[mid]<arr[right])
			    	right = mid-1;
			}
			return arr[mid]; // When we reach end of list and whole list is sorted
		}

}
