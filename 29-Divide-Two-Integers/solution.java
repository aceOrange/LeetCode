public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)   throw new IllegalArgumentException("Divisor cannot be zero!!!");
        if (divisor == 1)   return dividend;
        if (divisor == -1)  return (dividend==Integer.MIN_VALUE)? Integer.MAX_VALUE: -dividend;
        
        long p=Math.abs((long) dividend);
        long q=Math.abs((long) divisor);
        
        long res=0;
        while (p >=q) {
            int count=0;
            while (p>= (q << count))
                count++;
            res += (long)1 << (count-1);
            p -= q << (count-1);
        }
        
        if ((dividend > 0 && divisor >0) || (dividend <0 && divisor <0))
            return (int)res;
        else
            return (int) -res;
    }
}