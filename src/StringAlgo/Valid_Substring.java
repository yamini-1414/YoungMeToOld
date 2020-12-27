package StringAlgo;

import java.util.Scanner;
import java.util.Stack;

public class Valid_Substring {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		String str = sc.next();
		System.out.println(validString(str));
	}
}
public static int validString(String str) {
	Stack<Character> s = new Stack<Character>();
	for(int i=0;i<str.length();i++) {
		if(!s.isEmpty() && str.charAt(i)==')' && s.peek()=='(')
			s.pop();
		else
			s.push(str.charAt(i));
		}
	int cnt=0;
	while(!s.isEmpty()) {
		cnt++;
		s.pop();
	}
	return str.length()-cnt;
}

}
