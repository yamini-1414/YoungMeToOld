package Stack;

import java.util.Stack;

public class ParenthesisChecker {
public static boolean isParenthesisBalanced(String str) {
	if(str.length()==0)
		return true;
	Stack<Character> s = new Stack<Character>();
	for(int i=0;i<str.length();i++) {
		char ch = str.charAt(i);
		if(ch=='}') {
			 if(!str.isEmpty() && s.peek()=='{') 
				 s.pop();
			 else
				 return false;
		}
		else if(ch==')') {
			 if(!str.isEmpty() && s.peek()=='(')
				 s.pop();
			 else
				 return false;
		}else if(ch==']') {
			 if(!str.isEmpty() && s.peek()=='[')
				 s.pop();
			 else
				 return false;
		}else
			s.push(ch);
			
	}
	return s.isEmpty();
}
}
