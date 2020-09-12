package Searching;

import java.util.Scanner;

public class CountTriplets {
public static int count(int[] arr) {
	int max=0;
	int n = arr.length;
	for(int i=0;i<n;i++)
		max = Math.max(max, arr[i]);
	int[] freq = new int[max+1];
	for(int i=0;i<n;i++)
		freq[arr[i]]++;
	int ans=0;
	
	//Case 1: All zeroes (0,0,0) then f(0)C3 is the combinations possible;
	ans += (freq[0] * (freq[0]-1)*(freq[0]-2))/6;
	
	//Case 2: The case is (0,x,x) 0+x=x in this x appears twice f(0) * f(x)C2;
	for(int i=1;i<=max;i++)
		ans += freq[0] * (freq[0] * freq[i]*(freq[i]-1))/2;
	//Case 3: The case is (x,x,2*x) so the f(x)C2 * f(2*x);
	for(int i=1;2*i<=max;i++)
		ans += (freq[i]*(freq[i]-1)*freq[2*i])/2;
	//Case 4: the normal case (x,y,x+y) this case is simple f(x)*f(y)*(x+y)
	for(int i=1;i<=max;i++)
		for(int j=i+1;(i+j)<=max;j++)
			ans += (freq[i]*freq[j]*freq[i+j]);
	return ans;
}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++)
		    arr[i] = sc.nextInt();
		    System.out.println(count(arr)==0?-1:count(arr));
    }
		}
}
