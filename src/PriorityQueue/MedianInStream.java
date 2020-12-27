package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianInStream {
	PriorityQueue<Integer> minQueue;
	PriorityQueue<Integer> maxQueue;
	public MedianInStream() {
		minQueue = new PriorityQueue<Integer>();
		maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
	}
public void  add(int num) {
	if(minQueue.size()==0 && maxQueue.size()==0)
		minQueue.add(num);
	else if(num<minQueue.peek()) {
		if(maxQueue.size()>minQueue.size()) {
			int top = maxQueue.poll();
			minQueue.offer(Math.max(num, top));
			maxQueue.offer(Math.min(num, top));
		}else 
			maxQueue.offer(num);
		
	}else if(num>minQueue.peek()) {
		if(minQueue.size()>maxQueue.size())
			maxQueue.add(minQueue.poll());
		minQueue.add(num);
	}
}
public int findMedian() {
	if(minQueue.size()==maxQueue.size())
		return (minQueue.peek()+maxQueue.peek())/2;
	return maxQueue.size()>minQueue.size()?maxQueue.peek():minQueue.peek(); 
}
public static void main(String[] args) {
	MedianInStream m = new MedianInStream();
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	for(int i=0;i<n;i++) {
		int num = sc.nextInt();
		m.add(num);
		System.out.println(m.findMedian());
	}
	
}
}
