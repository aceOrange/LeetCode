public class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        
        int end = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                end = i;
            }
            else if (i == 0 || s.charAt(i-1) == ' ') {
                if (sb.length() != 0) {
                    sb.append(' ');
                }
                sb.append(s.substring(i, end));
            }
        }
        
        return sb.toString();
    }
}