package DP_Problems;
import java.util.Scanner;

public class MaxSumRectangle {
static class KadaneResult{
	int start;
	int end;
	int sum;
	KadaneResult(int start,int end,int sum){
		this.start = start;
		this.end = end;
		this.sum = sum;
	}
}
public static int maxSum(int[][] m) {
	int row = m.length; int col = m[0].length;
	int maxSum = Integer.MIN_VALUE;
    int[] temp = new int[row];
    for(int left=0;left<col;left++) {
    	for(int i=0;i<row;i++)
    		temp[i]=0;
        for(int right=left;right<col;right++) {
        	for(int i=0;i<row;i++)
        		temp[i] += m[i][right];
        	KadaneResult res = kadane(temp);
        	if(maxSum<res.sum)
        		maxSum = res.sum;
        }
    }
    return maxSum;
}
public static  KadaneResult kadane(int[] arr) {
	int maxSoFar = 0;
	int max = 0;
	int maxStart = -1;
	int end = -1;
	int currStart = 0;
	for(int i=0;i<arr.length;i++) {
		maxSoFar += arr[i];
		if(maxSoFar<0) {
			maxSoFar = 0;
			currStart = i+1;
		}
		if(max<maxSoFar) {
			maxStart = currStart;
			end = i;
			max = maxSoFar;
		}
	}
	return new KadaneResult(maxStart,end,max);
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
    for(int t=0;t<T;t++) {
    	int m = sc.nextInt();
    	int n = sc.nextInt();
    	int[][] matrix = new int[m][n];
    	for(int i=0;i<m;i++)
    		for(int j=0;j<n;j++)
    			matrix[i][j] = sc.nextInt();
    	System.out.println(maxSum(matrix));
    }
}
}
