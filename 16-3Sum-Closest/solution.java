public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("No solution");
        }
        
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        int ans = 0;
        
        for (int i = 0; i < nums.length -2; i = inc(nums, i)) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(sum - target) < close) {
                    close = Math.abs(sum - target);
                    ans = sum;
                }
                if (close == 0) return ans;
                if (sum > target) {
                    hi = dec(nums, hi);
                } else {
                    lo = inc(nums, lo);
                }
            }
        }
        return ans;
        
    }
    
    public int inc(int[] nums, int i) {
        while (i+1 < nums.length && nums[i] == nums[++i]) {}
        
        return i;
    }
    
    public int dec(int[] nums, int i) {
        while (i-1 >= 0 && nums[i] == nums[--i])    {}
        
        return i;
    }
}