package Arrays;

import java.util.Scanner;

public class Largest1Matrix {
	static class Node{
		int val;
		boolean visited;
		Node(int val){
			this.val = val;
			this.visited = false;
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
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++)
					nodes[i][j] = new Node(sc.nextInt());
			System.out.println(maxCount());
		}
	}
	static int maxCount() {
		int maxCount = 0;
		for(int i=0;i<nodes.length;i++) {
			for(int j=0;j<nodes[0].length;j++) {
				int val = solveUtil(i,j);
				if(maxCount<val)
					maxCount = val;
			}
		}
		return maxCount;
	}
	static boolean isValid(int x,int y) {
		if(x>=0 && x<nodes.length && y>=0 && y<nodes[0].length &&
				!nodes[x][y].visited && nodes[x][y].val!=0)
			return true;
		return false;
	}
    static  int solveUtil(int x,int y) {
		if(!isValid(x,y))
			return 0;
		nodes[x][y].visited = true;
	    return (1+solveUtil(x+1,y)+solveUtil(x-1,y)
	             +solveUtil(x,y-1)+solveUtil(x,y+1)
                 +solveUtil(x+1,y+1)+solveUtil(x+1,y-1)
                 +solveUtil(x-1,y-1)+solveUtil(x-1,y+1));
		
	}
}
