public class Solution {
    int[] nums;
    int[] copy;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.copy = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.copy;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int j = random.nextInt(i+1);
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */