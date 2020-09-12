package Bit_Manipulation;

public class SwapBits {
public static long swap(int i,int j,long x) {
	if(((x>>i)& 1) != ((x>>j)& 1)) {
		long bitmask = (1L<<i) | (1L<<j);
		x = x^bitmask;
	}
	return x;
}
}
