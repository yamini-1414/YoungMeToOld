package DP_Problems;

public class DiceRolls {
	static int MOD = 1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        long[][] dp = new long[d+1][target+1];
        dp[0][0]=1;
    for(int i=1;i<=d;i++)
        for(int num=1;num<=f;num++)
            for(int w=target;w>=num;w--)
                dp[i][w]= (dp[i][w] + dp[i-1][w-num])%MOD;
        return (int)dp[d][target];
    }
}
