package DP_Problems;

import java.util.Arrays;
import java.util.Comparator;

public class Box_stacking {
static class Box implements Comparable<Box>{
	int height;
	int width;
	int depth;
	Box(int height,int width,int depth){
		this.height = height;
		this.depth = depth;
		this.width = width;
	}
	@Override
	public int compareTo(Box arg0) {
		// TODO Auto-generated method stub
		return arg0.width*arg0.depth-this.width*this.depth;
	}
}
public static int boxStacking(int[][] arr) {
	if(arr.length==0) return 0;
	int n = arr.length;
    Box[] boxes = new Box[3*arr.length];
    for(int i=0;i<n;i++) {
    	boxes[3*i] = new Box(arr[i][0], Math.max(arr[i][1],arr[i][2]),Math.min(arr[i][1],arr[i][2]));
    	boxes[3*i+1] = new Box(arr[i][1], Math.max(arr[i][0], arr[i][2]),Math.min(arr[i][0], arr[i][2]));
    	boxes[3*i+2] = new Box(arr[i][2],Math.max(arr[i][0], arr[i][1]),Math.min(arr[i][0], arr[i][1]));
    }
    Arrays.sort(boxes);
    int[] msh = new int[3*n];
    for(int i=0;i<boxes.length;i++) {
    	Box box = boxes[i];
    	msh[i] = box.height;
    	for(int j=0;j<i;j++) {
    		if(box.width<boxes[j].width && box.depth<boxes[j].depth)
    			msh[i] = Math.max(msh[i], msh[j]+box.height);
    	}
        System.out.println(msh[i]);
    }
    return -1;
    
}
public static void main(String[] args) {
	int[][] arr = {{4,6,7},{1,2,3},{4,5,6},{10,12,32}};
	boxStacking(arr);
			
	}
}
