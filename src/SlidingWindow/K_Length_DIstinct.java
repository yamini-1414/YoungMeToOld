package SlidingWindow;

public class K_Length_DIstinct {
public static int countKdistinct(String str,int K) {
	if(str.length()<K) return 0;
	int res=0;
	int[] count  = new int[26];
	for(int i=0;i<K;i++)
		count[str.charAt(i)-'a']++;
	for(int i=K;i<str.length();i++) {
		count[str.charAt(i-K)-'a']--;
		count[str.charAt(i)-'a']++;
		if(check(count))
			res++;
	}
	return res;
}
public static boolean check(int[] count) {
	for(int i=0;i<26;i++) {
		if(count[i]>1)
			return false;
	}
	return true;
}
public static void main(String[] args) {
	System.out.println(countKdistinct("ihavefunonleetcode",5));
}
}
