package DP_Problems;
import java.util.Scanner;

public class EditDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			String str1 = sc.next();
			String str2 = sc.next();
			System.out.println(editDistance(str1,str2,m,n));
		}
	}
	public static int editDistance(String str1,String str2,int m,int n) {
		int[][] t = new int[m+1][n+1];
		for(int i=0;i<=n;i++)
			t[0][i] = i;
		for(int j=0;j<=m;j++)
			t[j][0] = j;
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1))
					t[i][j] = t[i-1][j-1] ;
				else
					t[i][j] = Math.min(t[i-1][j-1], Math.min(t[i-1][j], t[i][j-1]))+1;
			}
		}
		return t[m][n];
	}
}
