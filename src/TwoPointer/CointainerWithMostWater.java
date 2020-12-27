package TwoPointer;

public class CointainerWithMostWater {
	  public int maxArea(int[] height) {
	       if(height==null || height.length==0)
	           return 0;
	        int l = 0; int max=0; int r = height.length-1;
	        while(l<r){
	            max = Math.max(max,Math.min(height[l],height[r])*(r-l));
	            if(height[l]<height[r])
	                l++;
	            else
	                r--;
	        }
	        return max;
	    }
}
