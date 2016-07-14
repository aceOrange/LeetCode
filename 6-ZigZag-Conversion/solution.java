public class Solution {
    public String convert(String s, int nRows) {
        if (nRows <= 1) {
            return s;
        }
        
        int skip1 = 2 *(nRows - 1);
        int skip2 = skip1;
        
        StringBuilder str = new StringBuilder(); 
        for(int i = 0; i < nRows; i++) {
            if (i != 0 && i != nRows - 1)   skip2 -= 2;
            
            int index = i;
            
            while (index < s.length()) {
                if (index < s.length()) {
                    str.append(s.charAt(index));
                }
                if (i !=0 && i != nRows - 1 && index + skip2 < s.length()) {
                    str.append(s.charAt(index + skip2));
                }
                index += skip1;
            }
        }
        
        return str.toString();
    }
}