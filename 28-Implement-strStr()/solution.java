public class Solution {
    public int strStr(String haystack, String needle) {
        int N=haystack.length();
        int M=needle.length();
        
        int R=256;
        int[] right=new int[R];
        Arrays.fill(right,-1);
        
        for (int j=0;j<M;j++)
            right[needle.charAt(j)]=j;
            
        int skip;
        for(int i=0;i<=N-M;i += skip)
        {
            skip=0;
            for (int j=M-1;j>=0;j--)
            if (haystack.charAt(i+j) != needle.charAt(j))
            {
                skip=Math.max(1,j-right[haystack.charAt(i+j)]);
                break;
            }
            if (skip == 0) return i;
        }
        return -1;
    }
}