package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Walls_And_Gates {
	  private static final int GATE = 0;
	    private static final int EMPTY = Integer.MAX_VALUE;
	    private static final int WALL = -1 ;
	    public void wallsAndGates(int[][] rooms) {
	        if(rooms.length==0)
	            return;
	        int m = rooms.length; int n = rooms[0].length;
	        Queue<int[]> q = new LinkedList<>();
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(rooms[i][j]==GATE)
	                    q.offer(new int[]{i,j});
	            }
	        }
	        int[] dx = {0,0,-1,+1};
	        int[] dy = {-1,+1,0,0};
	       
	        while(!q.isEmpty()){
	             int[] point = q.poll();
	        int x = point[0]; int y = point[1];
	        for(int i=0;i<dx.length;i++){
	            int n_x = x+dx[i];
	            int n_y = y+dy[i];
	            if(n_x<0 || n_x>=m || n_y<0 || n_y>=n || rooms[n_x][n_y]!=EMPTY){
	                continue;
	            }
	            rooms[n_x][n_y] = rooms[x][y]+1;
	            q.offer(new int[]{n_x,n_y});
	        }
	    }
	    }
}
