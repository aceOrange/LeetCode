public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 0 && nums[i] < n && nums[i] != i) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        
        int i = 0;
        while (i < n && nums[i] == i) { i++; }
        
        return i;
    }
}