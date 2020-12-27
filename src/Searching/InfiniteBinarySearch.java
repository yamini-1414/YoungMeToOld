package Searching;

public class InfiniteBinarySearch {
static class ArrayReader{
	int[] arr;
	ArrayReader(int[] arr){
		this.arr = arr;
	}
	public int get(int index) {
		if(index>=arr.length)
			return Integer.MAX_VALUE;
		return arr[index];
	}
}
public static void infiniteBinarySearch(ArrayReader reader,int key) {
     int start = 0;
     int end = 1;
     
     while(reader.get(end)<key) {
    	 int newStart = end+1;
    	 end += (end-start+1)*2;
    	 start = newStart;
     }
      System.out.println(binarySearch(reader,start,end,key));
}
 static int binarySearch(ArrayReader reader,int start,int end,int key) {
       while(start<=end) {
    	   int mid = start + (end-start)/2;
    	   if(reader.get(mid)==key)
    		   return mid;
    	   else if(reader.get(mid)<key)
    		   start = mid+1;
    	   else if(reader.get(mid)>key)
    		   end = mid-1;
       }
       return -1;
 }
public static void main(String[] args) {
	int[] arr = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
	int key = 16;
	ArrayReader reader = new ArrayReader(arr);
	infiniteBinarySearch(reader, 16);
	
}
}
