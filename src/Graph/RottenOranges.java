package Graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {
	static class Node{
		int val;
		int x;
		int y;
		int time;
		Node(int val,int x,int y,int time){
			this.val = val;
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
public static void main(String[] args) {
	Scanner sc = new Scanner( System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int m = sc.nextInt();
		int n = sc.nextInt();
		Node[][] nodes = new Node[m][n];
		Queue<Node> q = new LinkedList<Node>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				nodes[i][j]= new Node(sc.nextInt(),i,j,0);
				if(nodes[i][j].val==2)
					((LinkedList<Node>) q).push(nodes[i][j]);
			}
		}
		System.out.println(findCount(nodes,q));
	}
}
static boolean isValid(Node[][] nodes,int x,int y) {
	if(x<0 || x>=nodes.length || y<0 || y>= nodes[0].length || nodes[x][y].val!=1)
		return false;
	return true;
}
static int findCount(Node[][] nodes,Queue<Node> q) {
	if(q.isEmpty())
		return -1;
	int cnt=0;
	while(!q.isEmpty()) {
		Node temp = q.poll();
		int n_x = temp.x;
		int n_y = temp.y;
		cnt = temp.time;
		if(isValid(nodes,n_x+1,n_y)) {
			nodes[n_x+1][n_y].val = 2;
			nodes[n_x+1][n_y].time = nodes[n_x][n_y].time+1;
			q.offer(nodes[n_x+1][n_y]);
		}
		if(isValid(nodes,n_x-1,n_y)) {
			nodes[n_x-1][n_y].val = 2;
			nodes[n_x-1][n_y].time = nodes[n_x][n_y].time+1;
			q.offer(nodes[n_x-1][n_y]);
		}
		if(isValid(nodes,n_x,n_y-1)) {
			nodes[n_x][n_y-1].val = 2;
			nodes[n_x][n_y-1].time = nodes[n_x][n_y].time+1;
			q.offer(nodes[n_x][n_y-1]);
		}
		if(isValid(nodes,n_x,n_y+1)) {
			nodes[n_x][n_y+1].val = 2;
			nodes[n_x][n_y+1].time = nodes[n_x][n_y].time+1;
			q.offer(nodes[n_x][n_y+1]);
		}
	}
	boolean flag = false;
	for(int i=0;i<nodes.length;i++) {
		for(int j=0;j<nodes[0].length;j++) {
			if(nodes[i][j].val==1)
				flag = true;
		}
	}
	return flag==true?-1:cnt;
}
}
