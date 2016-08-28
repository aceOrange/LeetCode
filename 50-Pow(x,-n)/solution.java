public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / pow(x, -n);
        } else {
            return pow(x, n);
        }
    }
    
    public double pow(double x, int n) {
        if (n == 0)     return 1;
        
        double half = pow(x, n/2);
        if (n % 2 == 0)     return half * half;
        else                return half * half * x;
    }
}