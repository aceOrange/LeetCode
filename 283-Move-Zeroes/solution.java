public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        //method #1
        /*
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        
        for (int i = pos; i < nums.length; i++) {
            nums[i] = 0;
        }
        
        return;
        */
        
        //method #2
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0)   continue;
            
            int j = i+1;
            while (j < n && nums[j] == 0) {
                j++;
            }
            
            if (j == n)   return;
            
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        
        return;
    }
}