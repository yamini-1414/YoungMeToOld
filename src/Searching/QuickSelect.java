package Searching;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect {
public static  int partition(int[] arr,int low,int high) {
	if(low==high) return low;
	int i=low;
	int pivot = arr[high];//ThreadLocalRandom.current().nextInt(low,high);
	//System.out.println(pivot);
	for(int j=low;j<high;j++) {
		if(arr[j]<=pivot) {
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i++]= temp;
		}
	}
	int temp = arr[i];
	arr[i] = arr[high];
	arr[high] = temp;
	return i;
}
public static boolean quickSelectSearch(int[] arr,int low,int high,int K) {
	while(low<=high) {
		if(low<high) {
		int rand = ThreadLocalRandom.current().nextInt(low,high);
		int temp = arr[rand];
		arr[rand] = arr[high];
		arr[high] = temp;
		}
		int mid = partition(arr,low,high);
		if(arr[mid]==K)
			return true;
		else if(arr[mid]<K)
			low = mid+1;
		else 
			high = mid-1;
	}
	return false;
}
public static void main(String[] args) {
	int[] arr = {7,10,4,3,20,15};
	for(int s:arr)
	System.out.println(quickSelectSearch(arr,0,arr.length-1,s));
}

}
