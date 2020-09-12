package Stack;

public class No_of_Islands {
	   public int numIslands(char[][] grid) {
	        if(grid.length==0)
	            return 0;
	        int count =0;
	        boolean[][] visited = new boolean[grid.length][grid[0].length];
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                if(grid[i][j]=='1' && !visited[i][j]){
	                    dfsUtil(grid,visited,i,j);
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
	    public boolean  isValid(boolean[][] visited,int i,int j){
	        return i>=0 && i<visited.length && j>=0 && j<visited[0].length && !visited[i][j] ;  
	    }
	    public void dfsUtil(char[][] grid,boolean[][] visited,int i,int j){
	        if(!isValid(visited,i,j) || grid[i][j]=='0') return;
	        visited[i][j] = true;
	        dfsUtil(grid,visited,i+1,j);
	        dfsUtil(grid,visited,i-1,j);
	        dfsUtil(grid,visited,i,j-1);
	        dfsUtil(grid,visited,i,j+1);
	        
	    }
}
