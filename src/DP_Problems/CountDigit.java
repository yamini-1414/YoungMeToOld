package DP_Problems;

public class CountDigit {
	static int[][] lookup;
	public static int countDigits(int n,int sum) {
	     if(n==0)
	    	 return sum==0?1:0;
	     if(sum==0)
	    	 return 1;
	     if(lookup[n][sum]!=-1)
	    	 return lookup[n][sum];
	     int ans=0;
	     for(int i=1;i<=9;i++)
	    	 if(sum-i>=0)
	    	    ans+= countDigits(n-1,sum-i);
	     lookup[n][sum]=ans;
	     return ans;
	}
public static void main(String[] args) {
	lookup = new int[1000][1000];
	for(int i=0;i<1000;i++)
		for(int j=0;j<1000;j++)
			lookup[i][j] = -1;
	System.out.println(countDigits(3,6));
}
}
