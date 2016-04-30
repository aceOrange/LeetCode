public class Solution {
    public boolean isMatch(String s, String p) {
        int lenS=s.length(), lenP=p.length();
        boolean[][] d=new boolean[lenS+1][lenP+1];
        d[0][0]=true;
        
        for (int j=0; j<lenP; j++){
            if (p.charAt(j)=='*') d[0][j+1]=d[0][j];
        }
        
        for (int i=1; i<= lenS; i++) {
            for (int j=1; j<=lenP; j++) {
                if (p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?')
                    d[i][j]=d[i-1][j-1];
                else if (p.charAt(j-1)=='*') {
                    for (int k=0; k<=i; k++) 
                        if (d[k][j-1]==true) {
                            d[i][j]=true;
                            break;
                    }
                }
            }
        }
        return d[lenS][lenP];
    }
}