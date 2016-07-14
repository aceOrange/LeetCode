public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] count = new int[256];
        int start = 0, numDistinct = 0, maxLen = 0;
        
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            if (count[s.charAt(i)] == 1) {
                numDistinct++;
                maxLen = Math.max(numDistinct, maxLen);
            } else {
                while (count[s.charAt(i)] > 1) {
                    if (s.charAt(start) != s.charAt(i)) numDistinct--;
                    count[s.charAt(start)]--;
                    start++;
                }
            }
        }
        
        return maxLen;
    }
}