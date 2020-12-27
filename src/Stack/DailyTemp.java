package Stack;

import java.util.Stack;

public class DailyTemp {
	public int[] dailyTemperatures(int[] T) {
        if(T.length==0)
            return null;
        int n = T.length;
        Stack<Integer> s = new Stack<Integer>();
        int[] res = new int[n];
    
        for(int i= n-1;i>=0;i--){
           while(!s.isEmpty() && T[i]>=T[s.peek()])s.pop();
            res[i] = s.isEmpty()?0:s.peek()-i;
            s.push(i);
        }
        return res;
    }
}
