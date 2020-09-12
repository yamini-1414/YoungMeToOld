package Stack;

import java.util.Stack;

public class InfixtoPostfix {
public static String infix2Post(String s) {
String res="";
Stack<Character> st = new Stack<Character>();
for(Character ch: s.toCharArray()) {
	if(Character.isLetter(ch) || Character.isDigit(ch)) {
		res += ch;
	}else if(ch=='(' ) {
		st.push(ch);
	}else if(ch==')') {
		while(!st.isEmpty() && st.peek()!='(')
			res += st.pop();
		if(!st.isEmpty() && st.peek()!='(' )
			return "Invalid Expression";
		else
			st.pop();
	}else {
		while(!st.isEmpty() && getPrec(ch)<=getPrec(st.peek())) {
			if(st.peek()=='(')
				return "Invalid Expression";
			res += st.pop();
		}
		st.push(ch);
	}
}
while(!st.isEmpty()) {
	if(st.peek()=='(')
		return "Invalid Expression";
	else
		res += st.pop();
}
return res;
}
static int getPrec(char op) {
	switch(op) {
	case'+':
	case '-':
		   return 1;
	case '*':
	case '/':
		   return 2;
	case '^': 
		   return 3;
	}
	return -1;
}

}
