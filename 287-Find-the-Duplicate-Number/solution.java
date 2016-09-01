public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        //method #1, binary search
        
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid)   cnt++;
            }
            
            if (cnt <= mid) lo = mid;
            else            hi = mid;
        }
        
        //check if the result is lo or hi
        int cnt = 0;
        for (int a : nums) {
            if (a <= lo)    cnt++;
        }
        if (cnt > lo)   return lo;  
        
        return hi;
    }
}