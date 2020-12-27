package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class LargestAreaHistogram {
public int histogramArea(ArrayList<Integer> heights) {
	if(heights.size()==0|| heights==null)
		return 0;
	Stack<Integer> s = new Stack<Integer>();
	int maxArea=0;
	int i=0;
	
	while(i<heights.size()) {
		if(s.isEmpty() || heights.get(s.peek())<= heights.get(i))
			s.push(i++);
		else {
			int top = s.pop();
			maxArea = Math.max(maxArea, heights.get(top)*(s.isEmpty()?i:i-s.peek()-1));
		}
	}
	while(!s.isEmpty()) {
		int top = s.pop();
		maxArea = Math.max(maxArea, heights.get(top)*(s.isEmpty()?i:i-s.peek()-1));
	}
	return maxArea;
}
}
