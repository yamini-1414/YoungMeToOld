package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Treasure_Island {
	static int[] dx = {-1,+1,0,0};
	static int[] dy = {0,0,+1,-1};
public  static int treasureIsland(char[][] grid) {
	if(grid.length==0) return 0;
	int m = grid.length; int n = grid[0].length;
	int i=0; int j=0;
	Queue<Integer> q = new LinkedList<Integer>();
	q.offer(i*n+j);
	grid[i][j]= 'D';
	int count=0;
	while(!q.isEmpty()) {
		int size = q.size();
		for(int k=0;k<size;k++) {
		int code = q.poll();
		int x = code/n; int y = code%n;
		if(grid[x][y]=='X') return count;
		grid[x][y] ='D';
		for(int l=0;l<dx.length;l++) {
			int n_x = x+dx[l];
			int n_y = y+dy[l];
			if(n_x<0 || n_x>=m || n_y<0 || n_y>=n || grid[n_x][n_y]=='D')
				continue;
			q.offer(n_x*n+n_y);
		}
	}
		count++;
	}
	return -1;
}
public static void main(String[] args) {
	char[][] grid = {{'O', 'O', 'O', 'O'},
			{'D', 'O', 'D', 'O'},
			{'O', 'O', 'O', 'O'},
			{'X', 'D', 'D', 'O'}};
	System.out.println(treasureIsland(grid));
}
}
