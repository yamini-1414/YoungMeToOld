package DP_Problems;

import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        Stack<Integer> s;
        int[][] t = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++)
            t[0][i] = matrix[0][i]=='0'?0:1; 
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
              if(matrix[i][j]=='0')
                  t[i][j] = 0;
              else
                  t[i][j] = t[i-1][j]+1;
            }
        }
        int finalArea=0;int maxArea=0;
        for(int i=0;i<matrix.length;i++){
                int index=0;
                s = new Stack<Integer>();
                maxArea=0;
                while(index<matrix[0].length){
                    if(s.isEmpty() || t[i][s.peek()]<=t[i][index])
                        s.push(index++);
                    else{
                        int top = s.pop();
                        maxArea = Math.max(maxArea,t[i][top]*(s.isEmpty()?index:index-s.peek()-1));
                    }
                }
                while(!s.isEmpty()){
                    int top = s.pop();
                     maxArea = Math.max(maxArea,t[i][top]*(s.isEmpty()?index:index-s.peek()-1));
                }
            finalArea = Math.max(finalArea,maxArea);
        }
        return finalArea;
        
    }
}
