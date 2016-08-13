public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listSet = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return  listSet; 
        }
        
        // Sort the array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i = inc(nums, i)) {
            int lo = i+1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]); list.add(nums[lo]); list.add(nums[hi]);
                    listSet.add(list);
                    lo = inc(nums, lo);
                    hi = dec(nums, hi);
                } else if (sum > 0) {
                    hi = dec(nums, hi);
                } else {
                    lo = inc(nums, lo);
                }
            }
        }
        return listSet;
    }
        
    public int inc(int[] nums, int i) {
        while (i+1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        return i+1;
    }
        
    public int dec(int[] nums, int i) {
        while (i-1 >= 0 && nums[i] == nums[i-1]) {
            i--;
        }
        return i-1;
    }
}