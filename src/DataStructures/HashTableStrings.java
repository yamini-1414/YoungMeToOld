package DataStructures;

public class HashTableStrings {
    //Polynomial Hashing Function
	// hash = s[0] + s[1]*p + s[2]*p^2 ..........s[n-1]*p^(n-1)
	public static int hashCode1( String s) {
		int p = 31;
		int M = (int)1e9 + 9;
		int power_of_p = 1;
		int hash_val = 0;
		for(int i=0;i<s.length();i++) {
			hash_val = (hash_val + (s.charAt(i)-'a'+1)*power_of_p )%M;
			power_of_p = (power_of_p*p)%M;
		}
		return hash_val;
	}
	// Same hash function implemented in the String class;
	//hash = s[0]*p^(n-1) + s1*p^(n-2) +.......s[n-1]*p^0;
	public static int hashCode2(String s) {
		int hash = 0;
		int h=hash;
		int p = 31;
		//int mod = (int)(1e9 + 9);
		char[] ch = s.toCharArray();
		for(int i=0;i<ch.length;i++) {
			h = (ch[i] + (p * h));
		}
		hash = h;
		return hash;
	}
	public static void main(String[] args) {
		String str = "christmas";
		System.out.println(hashCode1(str));
		System.out.println(str.hashCode() + " "+ hashCode2(str));
	}
}
