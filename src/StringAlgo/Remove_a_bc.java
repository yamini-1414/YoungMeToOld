package StringAlgo;

import java.util.Scanner;

public class Remove_a_bc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			String s = sc.next();
			System.out.println(removeString(s));
		}
	}

	public static String removeString(String str) {
		String res="";
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='b')
				continue;
			else if(i<str.length()-1 && str.charAt(i)=='a' && str.charAt(i+1)=='c') {
				i++;
				continue;
			}else
				res+=str.charAt(i);
		}
		return res;
	}
}
