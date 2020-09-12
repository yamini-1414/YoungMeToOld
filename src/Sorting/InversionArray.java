package Sorting;
public class InversionArray {
public static int mergeSort(int[] arr,int l,int r) {
	int count=0;
	     if(l<r) {
	    	 int mid = (l+r)/2;
	    	 count+=mergeSort(arr,l,mid);
	    	 count+=mergeSort(arr,mid+1,r);
	    	 count+=merge(arr,l,mid,r);
	     }
	     return count;
}
static int merge(int[] arr,int l,int m, int r) {
	int n1 = m-l+1;
	int n2 = r-m;
	int inv=0;
	int[] left = new int[n1];
	int[] right = new int[n2];
	
	for(int i=0;i<n1;i++)
		left[i] = arr[l+i];
	for(int j=0;j<n2;j++)
		right[j] = arr[j+1+m];
	
	int i=0;int j=0;int k=l;
	while(i<n1 && j<n2) {
		if(left[i]<=right[j]) {
			arr[k] = left[i];
			i++;
		}else {
			//if(left[i]>right[j]..then all the elements left[i+1],left[i+2],.....left[mid] will be greater than right[j] so m-i inversions)
			//System.out.println(left[i]+" "+right[j]);
			arr[k] = right[j];
			inv += m+1 -(l+i);
			j++;
		}
		k++;
	}
	while(i<n1) {
		arr[k] = left[i];
		i++; k++;
	}
	while(j<n2) {
		arr[k] = right[j];
		j++; k++;
	}
	return inv;
}
public static void main(String[] args) {
	int[] arr = {2,4,1,3,5};
	System.out.println(mergeSort(arr,0,arr.length-1));
}
}
