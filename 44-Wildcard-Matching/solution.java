public class Solution {
    public boolean isMatch(String s, String p) {
        int lenS=s.length(), lenP=p.length();
        boolean[][] d=new boolean[lenS+1][lenP+1];
        d[0][0]=true;
        
        for (int j=0; j<lenP; j++){
            if (p.charAt(j)=='*') d[0][j+1]=d[0][j];
        }
        
        for (int i=0; i<lenS; i++) {
            for (int j=0; j<lenP; j++) {
                if (p.charAt(j)==s.charAt(i) || p.charAt(j)=='?')
                    d[i+1][j+1]=d[i][j];
                else if (p.charAt(j)=='*') {
                    for (int k=0; k<=i+1; k++) 
                        if (d[k][j]==true) {
                            d[i+1][j+1]=true;
                            break;
                    }
                }
            }
        }
        return d[lenS][lenP];
    }
}