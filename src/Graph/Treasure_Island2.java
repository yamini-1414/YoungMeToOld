package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Treasure_Island2 {
public static int treasureIsland(char[][] grid) {
	if(grid.length==0) return 0;
	Queue<Integer> q = new LinkedList<Integer>();
	int m = grid.length ;int n = grid[0].length;int minCount=0;
	for(int i=0;i<m;i++) {
		for(int j=0;j<n;j++) {
			if(grid[i][j]=='S') 
				q.offer(i*n+j);
			    int count=0; 
			    while(!q.isEmpty()) {
			    	int size=q.size();
			    	for(int k=0;k<size;k++) {
			    		int code = q.poll();
			    		int x = code/n; int y = code%n;
			    		//System.out.println(x+" "+y+" "+count);
			    		if(grid[x][y]=='X') { 
			    		    System.out.println(count);
			    		    break;
			    		}
			    		if(x-1>=0 && grid[x-1][y]!='D') {
						    grid[x-1][y]=grid[x-1][y]!='O' && grid[x-1][y]!='S'?'X':'D';
						    q.offer((x-1)*n+y);
					}
					if(x+1<m && grid[x+1][y]!='D') {
					    grid[x+1][y]=grid[x+1][y]!='O' && grid[x+1][y]!='S'?'X':'D';
					    q.offer((x+1)*n+y);
				    }
					if(y-1>=0 && grid[x][y-1]!='D') {
					    grid[x][y-1]= grid[x][y-1]!='O' && grid[x][y-1]!='S' ? 'X' : 'D';
					    q.offer(x*n+(y-1));
				     }
					if(y+1<n && grid[x][y+1]!='D') {
					    grid[x][y+1]=grid[x][y+1]!='O'&& grid[x][y+1]!='S'?'X':'D';
					    q.offer(x*n+(y+1));
				      }
			    	}
			    	count++;
			}
		}
	}
	return -1;
}
public static void main(String[] args) {
	char[][] grid = {{'S', 'O', 'O', 'S', 'S'},
			         {'D', 'O', 'D', 'O', 'D'},
			         {'O', 'O', 'O', 'O', 'X'},
			         {'X', 'D', 'D', 'O', 'O'},
			         {'X', 'D', 'D', 'D', 'O'}};
	
	System.out.println(treasureIsland(grid));
}
}
