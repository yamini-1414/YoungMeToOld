package Graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NearestCell {
  static class Node{
	  int data;
	  int x;int y;
	  Node(int data,int x,int y){
		  this.data = data;
		  this.x=x; this.y = y;
	  }
  }
  static Node[][] nodes;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			nodes = new Node[m][n];
			Queue<Node> q = new LinkedList<Node>();
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					int d = sc.nextInt();
					if(d==1) {
						nodes[i][j] = new Node(0,i,j);
						q.add(nodes[i][j]);
					}
					else
					    nodes[i][j] = new Node(-1,i,j);		
				}
			}
	     while(!q.isEmpty()) {
		  Node temp = q.poll();
		   int[] dx = {-1,+1,0,0};
		   int[] dy = {0,0,-1,+1};
		   for(int i=0;i<dx.length;i++) {
			   int n_x = temp.x+dx[i];
			   int n_y = temp.y+dy[i];
			   if(isValid(n_x,n_y) && nodes[n_x][n_y].data==-1) {
				   nodes[n_x][n_y].data = temp.data+1;
			    q.add(nodes[n_x][n_y]);
			   }
		   }
	  }
	     for(int i=0;i<m;i++)
	    	 for(int j=0;j<n;j++)
	    		 System.out.print(nodes[i][j].data+" ");
	     System.out.println();
	}
		
	}
	static boolean isValid(int x,int y) {
		if(x>=0 && x<nodes.length && y>=0 && y<nodes[0].length)
			return true;
		return false;
	}
}

