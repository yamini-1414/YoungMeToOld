package Bit_Manipulation;

public class Count_parity {
public static void main(String[] args) {
	int n = 10001010;
	parity(n);
}
public static  short parity(int x) {
	short result = 0;
	while(x!=0) {
		result ^= 1;
		x = x&(x-1);
		System.out.println(x);
	}
	return result;
}
}
