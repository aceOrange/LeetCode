public class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        // Dynamic programming
        Arrays.sort(nums);
        int[] f = new int[target + 1];
        f[0] = 1;
        
        for (int sum = 1; sum <= target; sum++) {
            for (int num : nums) {
                if (sum >= num) {
                    f[sum] += f[sum - num];
                }
            }
        }
        
        return f[target];
    }
}