package Stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class NextGreater {
public static void nextGreater(int[] arr) {
	Stack<Integer> s = new Stack<Integer>();
	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	s.push(arr[0]);
	for(int i=1;i<arr.length;i++) {
		while(!s.isEmpty() && s.peek()<arr[i]) {
			map.put(s.peek(),arr[i]);
			s.pop();
		}
		s.push(arr[i]);
	}
	while(!s.isEmpty()) {
		map.put(s.peek(),-1);
		s.pop();
	}
	for(int i=0;i<arr.length;i++) {
		System.out.print(map.get(arr[i])+" ");
	}
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) 
			arr[i] = sc.nextInt();
		nextGreater(arr);
	}
}
}
