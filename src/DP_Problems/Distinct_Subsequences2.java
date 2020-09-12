package DP_Problems;

import java.util.Arrays;

public class Distinct_Subsequences2 {
	public int distinctSubseqII(String S) {
        int MOD = (int)Math.pow(10,9)+7;
        if(S==null || S.length()==0)
            return 0;
        int N = S.length();
        int[] last = new int[26];
        Arrays.fill(last,-1);
        int[] dp = new int[N+1];
        dp[0] = 1;
        for(int i=1;i<=N;i++){
            int ch = S.charAt(i-1);
            dp[i] = 2*dp[i-1]%MOD;
            if(last[ch-'a']!=-1){
                dp[i] =dp[i]-dp[last[ch-'a']];
                dp[i] = dp[i]%MOD;
            }
            last[ch-'a'] =i-1; 
        }
        dp[N]--;
        if(dp[N]<0) return dp[N]+MOD;
        return dp[N];
    }
}
