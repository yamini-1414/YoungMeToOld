package DP_Problems;

public class Partition_Problem {
public static boolean partition_2(int[] arr,int n,int sum,int[] pos) {
	if(sum==0) //good sign, there exists set of numbers that add to sum
		return true;
	if(n<0 || sum<0)
		return false;
	//Two choices 
	//Include the item and recur for remaining n-1 elements
	boolean include = partition_2(arr,n-1,sum-arr[n],pos);
	if(include) {
		pos[n] = 1;
		return true;
	}
	// Dont include the item 
	return partition_2(arr,n-1,sum,pos);
}
public static boolean partition_3(int[] arr,int n,int sum1,int sum2, int sum3,int[] pos) {
	//System.out.println(sum1+" "+sum2+" "+sum3);
	if(sum1==0 && sum2==0 && sum3==0)
		return true;
	if(n<0 || sum1<0 || sum2<0 || sum3<0 )
		return false;
	//Here we got three sets and the current element has three choices
	//1. It can go in first set 
	boolean A = partition_3(arr,n-1,sum1-arr[n],sum2,sum3,pos);
	if(A) { 
		pos[n] = 1;
		return true;
	}
	boolean B = partition_3(arr,n-1,sum1,sum2-arr[n],sum3,pos);
	if( !A && B) {
		pos[n] = 2;
		return true;
	}
	pos[n]= 3;
	return !A && !B &&  partition_3(arr,n-1,sum1,sum2,sum3-arr[n],pos);
}
public static void main(String[] args) {
	int[] arr =  { 7, 3, 2, 1, 5, 4, 8 };
	int sum=0;
	for(int x: arr) sum+=x;
	int[] pos = new int[arr.length];
	partition_3(arr,arr.length-1,sum/3,sum/3,sum/3,pos);
	for(int i=0;i<arr.length;i++)
		System.out.print(pos[i]+" ");
}
}
