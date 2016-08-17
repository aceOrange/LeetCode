public class Solution {
    public void nextPermutation(int[] nums) {
        int curr = nums.length - 1;
        while (curr > 0 && nums[curr-1] >= nums[curr]) {
            curr--;
        }
        
        reverse(nums, curr, nums.length - 1);
        
        if (curr > 0) {
            int next = curr;
            curr--;
            while (nums[curr] >= nums[next]) {
                next++;
            }
            swap(nums, curr, next);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int lo, int hi) {
        while (lo < nums.length && hi >= 0 && lo < hi) {
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }
}