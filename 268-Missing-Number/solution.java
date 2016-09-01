public class Solution {
    public int missingNumber(int[] nums) {
        /* Method 1: bit manipulation
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        
        res = res ^ nums.length;
        
        return res;
        */
        
        /* method 2: presum of array
        */
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        long all = 0;
        long sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            all += i;
            sum += nums[i];
        }
        
        return (int)(all - sum + nums.length);
    }
}
    