public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int close=nums[0]+nums[1]+nums[2];
        
        for (int i=0; i< nums.length-2;i=incIndex(nums, i)) {
            int a=nums[i], lo=i+1, hi=nums.length-1;
            while (lo<hi) {
                int b=nums[lo], c=nums[hi];
                if (a+b+c == target) return target;
                else if (Math.abs(a+b+c - target) < Math.abs(close-target)) {
                        close=a+b+c;
                     } 
                if (a+b+c > target) hi=decIndex(nums, hi);
                else                lo=incIndex(nums, lo);
            }
        }
        
        return close;
    }
    
    public int incIndex(int[] nums, int i) {
        while (i< nums.length-1 && nums[i]==nums[++i]) {}
        return i;
    }
    public int decIndex(int[] nums, int i) {
        while (i>0 && nums[i]== nums[--i]) {}
        return i;
    }
}