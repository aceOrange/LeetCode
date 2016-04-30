public class Solution {
    public String longestPalindrome(String s) {
    
    int maxLen=0, start=0, end=0;
    
    for (int i=0; i<s.length(); i++) {
        
        int lenA=searchCenter(s, i, i);
        int lenB=searchCenter(s, i, i+1);
        
        int len=Math.max(lenA, lenB);
        if (len > maxLen) {
            maxLen=len;
            start=i-(len-1)/2;
            end=i+len/2+1;
        }
    }
    return s.substring(start,end);
    }
    
    public int searchCenter(String s, int L, int R) {
        
        while (L>=0 && R< s.length() && s.charAt(L)==s.charAt(R)) {
            L--; R++;
        }
        
        return (R-1)-(L+1)+1;
    }
}