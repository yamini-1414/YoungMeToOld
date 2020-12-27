package Graph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeLaderProblem {
static class Node{
	int val;int move;
	Node(int val,int move){
		this.val = val;
		this.move = move;
	}
}
static Node[][] nodes;
public static void bfsUtil(HashMap<Integer,Integer> map) {
	boolean[] visited = new boolean[31];
	Queue<Node> q = new LinkedList<Node>();
	q.offer(new Node(1,0));
	visited[1] = true;
	int a=0;int b=0;
	while(!q.isEmpty()) {
		Node temp = q.poll();
		a = temp.val;
		b = temp.move;
		if(a==30)
			break;
		for(int i= a;i<a+6 && i<31;i++) {
			if(!visited[i]) {
				if(map.get(i)!=null)
				q.offer(new Node(map.get(i),b+1));
				else
					q.offer(new Node(i,b+1));
			}
		}
	}
	System.out.println(b);
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
			map.put(sc.nextInt(),sc.nextInt());
		bfsUtil(map);
	}
}
}
