package Graph;
import java.util.Scanner;

public class PathExist {
	static class Node{
		int val;
		int x;int y;
		boolean visited;
		Node(int val,int x,int y){
			this.val = val;
			this.x = x;
			this.y = y;
			this.visited= false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			Node src=null;
			Node[][] m = new Node[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int x = sc.nextInt();
					if(x==0)
						m[i][j] = new Node(x,i,j);
					else {
						if(x==1)
							src = new Node(1,i,j);
						m[i][j] = new Node(x,i,j);
					}
				}
			}
			System.out.println(pathExist(m,src.x,src.y)?1:0);
		}
	}
	static boolean isValid(Node[][] nodes,int x,int y) {
		if(x<0 || x>=nodes.length ||y<0 || y>=nodes[0].length || nodes[x][y].val==0 || nodes[x][y].visited)
			return false;
		return true;
	}
	static boolean pathExist(Node[][] nodes,int x,int y) {
		if(!isValid(nodes,x,y))
			return false;
		nodes[x][y].visited = true;
		if(nodes[x][y].val==2)
			return true;
		if(pathExist(nodes,x+1,y) || pathExist(nodes,x-1,y) || pathExist(nodes,x,y-1)|| pathExist(nodes,x,y+1))
			return true;
		return false;
	}
	
}
