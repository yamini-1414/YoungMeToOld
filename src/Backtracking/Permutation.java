package Backtracking;

public class Permutation {
public static void permutate(int[] arr,int index) {
	if(index==arr.length) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		return;
	}
	for(int i= index;i<arr.length;i++) {
		swap(arr,index,i);
		permutate(arr,index+1);
		swap(arr,index,i);
	}
}
static void swap(int[] arr,int i,int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}
public static void main(String[] args) {
	int[] arr = {1,2,3,4};
	permutate(arr,0);
}
}

