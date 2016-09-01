public class Solution {
    public int missingNumber(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        
        res = res ^ nums.length;
        
        return res;
    }
}
    