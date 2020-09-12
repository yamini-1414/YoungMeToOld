package Arrays;

import java.util.Scanner;

public class RotateArray {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
		    int n = sc.nextInt();
		    int d = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++)
		    arr[i] = sc.nextInt();
		    rotateArray(arr,n,d);
		}
	}
	public static int gcd(int a,int b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	static void rotateArray(int[] arr,int n,int d) {
		int j,k,temp;
		int g_c_d = gcd(n,d);
		for(int i=0;i<g_c_d;i++) {
			temp = arr[i];
			j= i;
			while(true) {
				k = j+d;
				if(k>=n)
					k = k-n;
				if(k==i)
					break;
				arr[j] =arr[k];
				j= k;
			}
			arr[j] = temp;
		}
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
