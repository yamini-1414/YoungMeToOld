package StringAlgo;

public class KMP_String_Algo {
public static int[] constructArray(String pattern) {
	int i=1; int j=0;
	int m = pattern.length();
	int[] lps = new int[m];
	while(i<m) {
		if(pattern.charAt(i)==pattern.charAt(j)) {
			j++;
			lps[i] = j;
			i++;
		}else {
			if(j!=0)
				j = lps[j-1];
			else
				i++;
		}
	}
	return lps;
}
public static boolean isMatch(String text, String pattern) {
	int i=0; int j=0;
	int[] lps = constructArray(pattern);
	int m = pattern.length() ; int n = text.length();
	while(i<n) {
		if(text.charAt(i)==pattern.charAt(j)) {
			i++;
			j++;
			if(j==m)
				return true;
		}else if(i<n && text.charAt(i)!=pattern.charAt(j)) {
			if(j!=0)
				j = lps[j-1];
			else
				i++;
		}
	}
	return false;
}
public static  int repeatedStringMatch(String A, String B) {
     String res = A;
     for(int i=1 ;i<=((int)Math.ceil(B.length()/A.length()))+2;i++,res+=A) {
    	 if(isMatch(res,B)) return i;
     }
     return -1;
}
public static void main(String[] args) {
	String A = "abcd"; String B = "cdabcdab";
	System.out.println(repeatedStringMatch(A,B));
}
}
