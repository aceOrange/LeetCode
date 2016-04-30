public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> ansSet=new ArrayList<List<Integer>>();
        List<Integer> ans=new ArrayList<Integer>();
        
        for(int i=0; i<nums.length-2;i=incIndex(nums,i)) {
            int a= nums[i], lo=i+1, hi=nums.length-1;
            while (lo < hi) { 
                int b=nums[lo], c=nums[hi];
                if (a+b+c==0) {
                    ans = Arrays.asList(a,b,c);
                    ansSet.add(ans);
                    lo=incIndex(nums, lo);
                    hi=decIndex(nums, hi);
                }
                else if (a+b+c>0) hi=decIndex(nums, hi);
                else if (a+b+c<0) lo=incIndex(nums, lo);
            }
        }
        
        return ansSet;
    }
    
    public int incIndex(int[] nums, int i) {
        while (i< nums.length-1 && nums[i]==nums[++i]) {};
        return i;
    }
    public int decIndex(int[] nums, int i) {
        while (i>0 && nums[i]==nums[--i]) {};
        return i;
    }
}