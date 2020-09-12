package TwoPointer;

public class Remove_Duplicates_Adj {
	public String removeDuplicates(String S) {
        if(S.length()<=1)
            return S;
        int i=1,j =0;
        char[] ch = S.toCharArray();
        while(i<S.length()){
            if(j>=0 && ch[i]==ch[j]){
                i++;
                j--;
            }else{
                j++; // Index that places the result string in correct position
                //place at correct position in the string
                ch[j] = ch[i];
                i++;
            }
        }
        S = new String(ch);
        return S.substring(0,j+1);
    }
}
