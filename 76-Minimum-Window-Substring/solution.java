public class Solution {
    public String minWindow(String s, String t) {
        
        if (s == null || t == null) {
            return "";
        }
        
        
        int[] count = new int[256];
        String result = "";
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }
        
        int start = 0;
        int sLen =0, tLen = t.length();
        
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] > 0) {
                sLen++;
            }
            count[s.charAt(i)]--;
            
            while (sLen >= tLen) {
                if (minLen > i - start + 1) {
                    minLen = i-start+1;
                    result = s.substring(start, i+1);
                }
                count[s.charAt(start)]++;
                if (count[s.charAt(start)] > 0) {
                    sLen--;
                }
                start++;
            }
        }
        
        return result;
        
    }
}