package Graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightWalk {
public static class Node{
	int x;int y;
	int val;
	boolean visited;
	Node(int x,int y,int val){
		this.val = val;
		this.x = x; this.y = y;
		this.visited = false;
	}
}
static Node[][] nodes;
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		nodes = new Node[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				nodes[i][j] = new Node(i,j,0);
		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		System.out.println(bfsUtil(s1,s2,d1,d2));
	}
}
static int bfsUtil(int s1,int s2,int d1,int d2) {
	Queue<Node> q = new LinkedList<Node>();
	 int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 }; 
	 int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	 nodes[s1][s2] = new Node(s1,s2,0);
	 q.offer(nodes[s1][s2]);
	 while(!q.isEmpty()) {
		 Node temp = q.poll();
		 temp.visited = true;
		 if(temp.x==d1 && temp.y==d2)
		    return temp.val;
		 for(int i=0;i<dx.length;i++) {
			 int n_x = temp.x+dx[i];
			 int n_y = temp.y+dy[i];
			 if(isValid(nodes,n_x,n_y)) {
				 nodes[n_x][n_y].val = temp.val+1;
				 q.offer(nodes[n_x][n_y]);
		       }
	     }
	 }
	 return 0;
}
static boolean isValid(Node[][] nodes,int x,int y) {
	if(x>=0 && x<nodes.length && y>=0 && y<nodes[0].length
			&& !nodes[x][y].visited)
		return true;
	return false;
}
}
