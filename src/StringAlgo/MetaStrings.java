package StringAlgo;

import java.util.Scanner;

public class MetaStrings {
public static boolean metaString(String str1,String str2) {
	if(str1.length()!=str2.length())
		return false;
	int sum=0; int cnt=0;
	for(int i=0;i<str1.length();i++) {
		if(str1.charAt(i)!=str2.charAt(i)) {
			cnt++;
			sum += str1.charAt(i)-str2.charAt(i);
			if(cnt>2)
				break;
		}
	}
      return cnt==2 && sum==0?true:false;
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.println(metaString(str1,str2)?"1":"0");
	}
}
}
