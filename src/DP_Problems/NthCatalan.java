package DP_Problems;
import java.math.BigInteger;
import java.util.Scanner;

public class NthCatalan {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		System.out.println(nthCatalan(n));
	}
}
public static BigInteger nthCatalan(int n) {
	BigInteger[] dp = new BigInteger[n+1];
	dp[0] = dp[1] = BigInteger.ONE;
	for(int i=2;i<=n;i++) {
		dp[i] = BigInteger.ZERO;
		for(int j=1;j<=i;j++)
			dp[i] = dp[i].add( dp[j-1].multiply(dp[i-j]));
	}
	return dp[n];
}
}
