public class Solution {
    public int minDistance(String word1, String word2) {
        int len1=word1.length(), len2=word2.length();
        
        int[][] d=new int[len1+1][len2+1];
        for(int i=0; i<=len1; i++)
            for(int j=0; j<=len2; j++) {
                if (i==0 || j==0) d[i][j]=Math.max(i,j);
                else {
                    d[i][j]=Math.min(Math.min(d[i-1][j], d[i][j-1])+1, 
                            d[i-1][j-1] + ( (word1.charAt(i-1)==word2.charAt(j-1))? 0:1));
                }
            }
        
        return d[len1][len2];
    }
}