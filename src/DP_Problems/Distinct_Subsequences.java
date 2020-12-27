package DP_Problems;

public class Distinct_Subsequences {
public int numDistinct(String s, String t) {
        if(s==null || t==null)
        	return 0;
        int[][] dp = new int[t.length()+1][s.length()+1];
        //No subsequences can be formed with a empty string
        for(int i=0;i<=t.length();i++)
        	dp[i][0] = 0;
        //An empty string is a subsequence of all strings
        for(int i=0;i<=s.length();i++)
        	dp[0][i] = 1;
        for(int i=1;i<=t.length();i++) {
        	for(int j=1;j<=s.length();j++) {
        		if(t.charAt(i-1)==s.charAt(j-1))
                    // We have a choice either to include it or exclude that in S and move forward
        			dp[i][j] = dp[i][j-1]+dp[i-1][j-1];
        		else
        			dp[i][j] = dp[i][j-1];
        			
        	}
        }
        return dp[t.length()][s.length()];
    }
}
