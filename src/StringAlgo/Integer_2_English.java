package StringAlgo;

public class Integer_2_English {
	static String[] a = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
			"Sixteen","Seventeen","Eighteen","Nineteen"};
	static String[] b = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninty"};
	static String[] c = {"","Hundred"};
	public static String convert(int num) {
	     StringBuilder str = new StringBuilder();
	     while(num>0) {
	    	 if(num>=100) {
	    	 str.append(a[num/100]+" ");
	    	 str.append("Hundred ");
   	    	 num = num%100;
	    	 }else if(num<20) {
	    		 str.append(a[num]+" ");
	    		 num = num/20;
	    	 }else  {
	    		 str.append(b[num/10]+" ");
	    		 num = num%10;
	    	 }
	     }
	     return str.toString();
	}
	public static String convertLarge(int num) {
		StringBuffer str = new StringBuffer();
		while(num>0) {
		if(num>(int)Math.pow(10, 9)) {
			int x = num/(int)(Math.pow(10, 9));
			str.append(a[x]+" Billion ");
			num = num%(int)Math.pow(10, 9);
		}else if(num>1000000) {
			str.append(convert(num/1000000)+"Million ");
			num = num%1000000;
		}else if(num>1000) {
			str.append(convert(num/1000)+"Thousand ");
			num = num%1000;
		}else {
			str.append(convert(num));
			num = 0;
		}
		}
		return str.toString();
	}
public static void main(String[] args) {
	System.out.println(convertLarge(1234567));
}
}
