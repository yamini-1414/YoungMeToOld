package DP_Problems;

public class Floyd_Warshall {
public static void main(String[] args) {

}
public void shortestPath(int[][] adjMatrix,int N) {
	int[][] dist = new int[N][N];
	for(int i=0;i<N;i++) 
		for(int j=0;j<N;j++) 
				dist[i][j] =  adjMatrix[i][j];
	
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE && dist[i][k]+dist[k][j]<dist[i][j])
						dist[i][j] = dist[i][k]+dist[k][j];
				}
				if(dist[i][i]<0)
					System.out.println("There exists negative cycle");
			}
		}
}
}
