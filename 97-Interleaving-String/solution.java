public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length(), n2=s2.length(), n3=s3.length();
        if (n1+n2 != n3) return false;
        
        boolean[][] d = new boolean[n1+1][n2+1];
        
        d[0][0]=true;
        
        for (int i=1; i<=n1; i++) {
            d[i][0]=d[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
        }
        for (int j=1; j<=n2; j++) {
            d[0][j]=d[0][j-1] && s2.charAt(j-1)==s3.charAt(j-1);
        }
        
        for (int i=1; i<=n1; i++) 
            for (int j=1; j<=n2; j++) {
                d[i][j]= (d[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)) ||
                         (d[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        return d[n1][n2];
    }
}