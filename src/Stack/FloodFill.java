package Stack;

public class FloodFill {
	 public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	      if(image.length==0)
	          return null;
	      int color = image[sr][sc];
	     if(color!=newColor) dfsUtil(sr,sc,color,image,newColor);
	     return image; 
	    }
	    public void dfsUtil(int i,int j,int color,int[][] image,int newColor){
	        if(i<0 || i>= image.length || j<0 || j>=image[0].length|| image[i][j]!=color)
	            return;
	        image[i][j] = newColor;
	        dfsUtil(i+1,j,color,image,newColor);
	        dfsUtil(i-1,j,color,image,newColor);
	        dfsUtil(i,j-1,color,image,newColor);
	        dfsUtil(i,j+1,color,image,newColor);
	    }
}
