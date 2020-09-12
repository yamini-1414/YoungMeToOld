package Stack;

import java.util.Stack;

public class EvalReversePolish {
	  public int evalRPN(String[] tokens) {
	        if(tokens.length==0)
	            return 0;
	        Stack<Integer> s = new Stack<Integer>();
	        for(int i=0;i<tokens.length;i++){
	            char ch = tokens[i].charAt(0);
	            if(Character.isDigit(ch))
	                s.push(Integer.parseInt(tokens[i]));
	            else if(s.size()>1){
	                System.out.println(s);
	                int op2 = s.pop();
	                int op1 = s.pop();
	                if(ch=='+')
	                    s.push(op2+op1);
	                else if(ch=='-')
	                    s.push(op1-op2);
	                else if(ch=='*')
	                    s.push(op1*op2);
	                else if(ch=='/')
	                    s.push((int)op1/op2);
	                }
	            }
	        return s.isEmpty()?0:s.peek();
	    }
}
