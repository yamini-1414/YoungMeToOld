package Arrays;

public class Spiral_Matric {
public static void spiralMatrix(int n) {
	int count=1;
	int[][] matrix = new int[n][n];
	int left = 0;int right = n-1;int up=0; int down = n-1;
	while(left<=right && up<=down && count<=n*n) {
		for(int i=left;i<=right;i++)
			matrix[up][i] =count++;
		up++;
		for(int i=up;i<=down;i++)
			matrix[i][right] = count++;
		right--;
		for(int i=right;i>=left;i--)
			matrix[down][i] = count++;
		down--;
		for(int i=down;i>=up;i--)
			matrix[i][left] = count++;
		left++;
	}

for(int i=0;i<n;i++) {
	for(int j=0;j<n;j++)
		System.out.print(matrix[i][j]+" ");
 System.out.println();
}
}
public static void main(String[] args) {
	spiralMatrix(6);
}
}