package Stack;

import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s ;
    Stack<Integer> minStack;
    public MinStack() {
        s = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        s.push(x);
        if(minStack.isEmpty() || x<=minStack.peek())
            minStack.push(x);
    }
    
    public void pop() {
        if(!s.isEmpty() && !minStack.isEmpty()){
            if(s.peek()-minStack.peek()==0)
                minStack.pop();
          s.pop();
        }
    }
    
    public int top() {
        return s.isEmpty()?-1:s.peek();
    }
    
    public int getMin() {
    
        return minStack.isEmpty()?-1:minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */