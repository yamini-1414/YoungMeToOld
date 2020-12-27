package Searching;

public class Median_diff_length {
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         if(nums1.length>nums2.length)
	        	return findMedianSortedArrays(nums2,nums1);
         int length1 = nums1.length;
	        int length2 = nums2.length;
	        int low = 0;
	        int high = length1;
	        while(low<=high) {
	        	int parX = (low+high)/2;
	        	int parY = (length1+length2+1)/2-parX;
	        	
	        	int maxLeftX = parX==0?Integer.MIN_VALUE:nums1[parX-1];
	        	int minRightX = parX==length1?Integer.MAX_VALUE:nums1[parX];
	        	
	        	int maxLeftY = parY==0?Integer.MIN_VALUE:nums2[parY-1];
	        	int minRightY = parY==length2?Integer.MAX_VALUE:nums2[parY];
	        	
	        	if(maxLeftX<=minRightY && maxLeftY<=minRightX) {
	        		if((length1+length2)%2==0)
	        			return (double)(Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2;
	        		else
	        			return (double)Math.max(maxLeftX,maxLeftY);
	        	}else if(maxLeftX>minRightY)
	        		high = parX-1;
	        	else
	        		low = parX+1;
	        	
	        }
	        throw new IllegalArgumentException(); 
 
	    }
}
