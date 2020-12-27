package Arrays;

import java.util.Scanner;

public class SubMatrixSum {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] cell = new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				cell[i][j] = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		System.out.println(subMatrixSum(cell,x1-1,y1-1,x2-1,y2-1));
	}
	}	
	public static int subMatrixSum(int[][] matrix,int x1,int y1,int x2,int y2){

		   int[][] sum = new int[matrix.length][matrix[0].length];
		   for(int i=0;i<matrix.length;i++)
		     for(int j=0;j<matrix[0].length;j++)
				sum[i][j] = (i-1>=0?sum[i-1][j]:0)+(j-1>=0?sum[i][j-1]:0)
						-(i-1>=0 && j-1>=0?sum[i-1][j-1]:0)+matrix[i][j];	   
		   return sum[x2][y2] - (y1-1>=0?sum[x2][y1-1]:0)-(x1-1>=0?sum[x1-1][y2]:0) +(x1-1>=0 && y1-1>=0?sum[x1-1][y1-1]:0);
		   }
}