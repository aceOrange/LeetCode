public class Solution {
    public String longestPalindrome(String s) {
        
        if ( s== null || s.length() == 0) {
            return "";
        }
        
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            
            //case #1
            String str1 = searchCenter(s, i, i);
            if (str1.length() > result.length()) {
                result = str1;
            }
            
            String str2 = searchCenter(s, i, i+1);
            if (str2.length() > result.length()) {
                result = str2;
            }
        }
        
        return result;
        
    }
    
    public String searchCenter(String s, int lo, int hi) {
        
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        
        return s.substring(lo+1, hi);
    }
}