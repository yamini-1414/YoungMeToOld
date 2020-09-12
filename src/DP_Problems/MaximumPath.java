package DP_Problems;

public class MaximumPath {
public static void maxPath(int[][] grid) {
	int m = grid.length; int n = grid[0].length;
	int[][] dp = new int[m][n];
	for(int i=m-1;i>=0;i--)
		for(int j=n-1;j>=0;j--)
			dp[i][j] += Math.max(i-1>=0?dp[i-1][j]:0, j-1>=0?dp[i][j-1]:0);
	
	for(int i=0;i<m;i++) {
		for(int j=0;j<n;j++)
			System.out.print(dp[i][j]+" ");
		System.out.println();
	}
}
public static void main(String[] args) {
	int[][] grid = {{5,4,5},
			{1,2,6},
			{7,4,6}};
	maxPath(grid);
	
	}
}

