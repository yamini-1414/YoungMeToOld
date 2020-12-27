package StringAlgo;

public class Remove_PalindromicSubseq {
public static void remove(String S) {
	int n = S.length();
	int[][] T = new int[n][n];
	for(int i=0;i<n;i++)
		T[i][i] = 1;
	int max_l=0; int max_h=0;
	for(int len=1;len<n;len++) {
		for(int l=0,h=len;h<n;l++,h++) {
			if(S.charAt(l)==S.charAt(h))
		      T[l][h] = T[l+1][h-1]+2;
			else {
				if(T[l+1][h]>T[l][h-1]) {
					max_l = l+1;
					max_h = h;
					T[l][h] = T[l+1][h];
				}else {
					max_l = l;
					max_h = h-1;
					T[l][h] = T[l][h-1];
				}
			}
		}
	}
	System.out.println(max_l+" "+max_h);
}
public static void main(String[] args) {
	String S = "agbdba";
	remove(S);
}
}
