package Graph;

public class Number_Of_Islands {
static class UnionFind{
	int count;
	int[] parent;
	int[] rank;
	
	public UnionFind(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] parent = new int[m*n];
		int[] rank = new int[m*n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]=='1')
					count++;
				 parent[i*n+j] = i*n+j;
			}
		}
	}
	public int find(int x) {
		if(parent[x]!=x)
			parent[x]= find(parent[x]);
		return parent[x];
	}
	public boolean union_find(int x,int y) {
		int fx = find(x);
		int fy = find(y);
		if(fx==fy) return false;
		if(rank[x]>rank[y])
			parent[y] = x;
		else if(rank[y]>rank[x])
			parent[x]= y;
		else {
			parent[y]=x;
			rank[x]++;
		}
		--count;
		 return true;
	}
}
public int numIslands(char[][] grid) {
	if(grid.length==0) return 0;
	int m = grid.length;
	int n = grid[0].length;
	UnionFind uf  = new UnionFind(grid);
	for(int i=0;i<m;i++) {
		for(int j=0;j<n;j++) {
			if(grid[i][j]=='1') {
				grid[i][j]='0';
				if(i-1>=0 && grid[i-1][j]=='1') {
					grid[i-1][j] = '0';
					uf.union_find(i*n+j, (i-1)*n+j);
				}
				if(i+1<m && grid[i+1][j]=='1') {
					grid[i+1][j] = '0';
					uf.union_find(i*n+j,(i+1)*n+j);
				}
				if(j-1>=0 && grid[i][j-1]=='1') {
					grid[i][j-1] = '0';
					uf.union_find(i*n+j, i*n+(j-1));
				}
				if(j+1<n && grid[i][j+1]=='1') {
					grid[i][j+1] = '0';
					uf.union_find(i*n+j,i*n+(j+1));
				}
			}
		}
	}
	return uf.count;
}
}
