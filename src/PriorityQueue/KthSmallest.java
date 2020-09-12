//Using quickSelect approach
package PriorityQueue;
public class KthSmallest {
	public static int  kthLargest(int[] arr,int k) {
		k = arr.length-k+1;
		int pivot = pivotFind(arr,0,arr.length-1);
		int start = 0; int end = arr.length-1; 
		while(pivot!=k-1) {
			if(k-1<pivot)
				end = pivot-1;
			else
				start = pivot+1;
			pivot = pivotFind(arr,start,end);
		}
		return arr[k-1];
	}
	static int pivotFind(int[] arr,int start,int end) {
		int pivotEle = 0;
		int pivot =arr[start];
		while(start<=end) {
			while(start<=end && arr[start]<=pivot)
				start++;
			while(start<=end && arr[end]>pivot)
				end--;
			if(start>end) {
				int temp = arr[pivotEle];
				arr[pivotEle] = arr[end];
				arr[end] = temp;
			}else {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		return end;
	}
	public static void main(String[] args) {
		int[] arr = {3,8,4,1,5,9};
		System.out.println(kthLargest(arr,3));
		
	}
}
