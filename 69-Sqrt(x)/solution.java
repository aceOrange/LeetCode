public class Solution {
    public int mySqrt(int x) {
        
        //corner case
        if (x < 2)  return x;
        
        int lo = 1, hi = x;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            int num = x / mid;
            if (num == mid) {
                return mid;
            } else if (num > mid) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        if (x / hi == hi)   return hi;
        else                return lo;
    }
}