package Arrays;

public class MiddleSum {
public static void main(String[] args) {
	
}
public static int middleSum(int[] a,int[] b) {
	int i=0; int j=0; int k = a.length;
	while(k>0) {
		if(a[i]<b[j]) {
			i++;
			k--;
		}else if(a[i]>b[j]) {
			j++;
			k--;
		}else {
			i++;j++;k--;k--;
		}
	}
	if(a[i]<b[j] && a[i+1]<b[j]) {
		return(a[i]+a[i+1]);
	}
	else if(b[j]<a[i] && b[j+1]<a[i]) {
		return (b[j]+b[j+1]);
	}
	return a[i]+b[j];
}
}
