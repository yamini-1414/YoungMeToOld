package Bit_Manipulation;

public class Closest_number {
public static long closest_num(int n) {
	for(int i=0;i<n-1;i++) {
		if((n>>i & 1) !=(n>>i+1 & 1)) {
			n^= 1L<<i | 1L<<i+1;
		}
	}
		return n;
}
}
