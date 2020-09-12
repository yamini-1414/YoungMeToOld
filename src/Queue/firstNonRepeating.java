package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class firstNonRepeating {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
	int n = sc.nextInt();
	Queue<Character> q  = new LinkedList<Character>();
	int[] freq = new int[26];
    for(int i=0;i<n;i++) {
    	char ch = sc.next().charAt(0);
    	freq[ch-'a']++;
    	q.offer(ch);
    	while(!q.isEmpty()) {
    		if(freq[q.peek()-'a']>1)
    			q.poll();
    		else {
    			System.out.print(q.peek()+" ");
    			break;
    		}
    		if(q.isEmpty())
    			System.out.print("-1"+" ");
    	}
    }
    System.out.println();
	}
}
}
