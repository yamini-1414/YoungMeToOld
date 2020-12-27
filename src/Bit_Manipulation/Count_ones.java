package Bit_Manipulation;

public class Count_ones {
public static void main(String[] args) {
	System.out.println(count_ones(8));
}
public static int count_ones(int n) {
	int cnt = 0;
	while(n!=0) {
		n = n&(n-1);
		cnt++;
	}
	return cnt;
}
}
