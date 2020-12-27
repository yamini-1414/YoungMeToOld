package Searching;
public class LocalMinimum {
     public static int getMin(int[] arr,int left,int right) {
    	 if(left>right)
    		 return 0;
    	 int count = 0;
    	 System.out.println(left+" "+right);
    	 if(left<=right) {
    		 int mid = (left+right)/2;
    		
    		 if(mid+1<arr.length && arr[mid]<arr[mid+1])
    			 count++;
    		 else if(mid-1>=0 && arr[mid]>arr[mid-1])
    			 count++;
    		 count += getMin(arr,left,mid-1);
    		 count +=getMin(arr,mid+1,right);
    	 }
    	 return count;
     }
     public static void main(String[] args) {
    	 int[] arr = {2,3,4,5,6};
    	 System.out.println(getMin(arr,0,3));
     }
}
 