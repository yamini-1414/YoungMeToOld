package Bit_Manipulation;

public class Reverse_digits {
	   public int reverse(int x) {
	         boolean isNeg = x<0;
	         int n = Math.abs(x); int res =0;
	         while(n!=0) {
	        	 res = res*10 + x%10;
	        	 x = x/10;
	         }
	         return isNeg? -res: res;
	    }
}
