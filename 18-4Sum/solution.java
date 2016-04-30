public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> listSet = new ArrayList<List<Integer>>();
        if (nums.length<4) return listSet;
        
        Arrays.sort(nums);
        
        for (int i=0; i< nums.length-3; i=incIndex(nums, i)) 
            for (int j=i+1; j< nums.length-2; j=incIndex(nums,j)) {
                int a=nums[i], b=nums[j], lo=j+1, hi=nums.length-1;
                while (lo<hi) {
                    int c=nums[lo], d=nums[hi];
                    if (a+b+c+d == target) {
                        List<Integer> list = Arrays.asList(a,b,c,d);
                        listSet.add(list);
                        lo=incIndex(nums, lo);
                        hi=decIndex(nums, hi);
                    }
                    else if (a+b+c+d > target) hi=decIndex(nums, hi);
                    else                       lo=incIndex(nums, lo);
                }
            }
        return listSet;
    }
    
    public int incIndex(int[] nums, int i) {
        while (i<nums.length-1 && nums[i]==nums[++i]) {};
        return i;
    }
    
    public int decIndex(int[] nums, int i) {
        while (i>0 && nums[i] == nums[--i]) {};
        return i;
    }
}