
import java.util.Hashtable;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        
        Hashtable<Integer,Integer> ht=new Hashtable<Integer,Integer>();
        int[] index={0,0};
        for(int i=0;i<nums.length;i++){
            ht.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++){
            int t=0;
            int gap=target-nums[i];
            if (ht.get(gap)!=null) t=ht.get(gap);
            if (t>i) {
                index[0]=i;
                index[1]=t;
                break;
            }
        
        }
        
        return index;
    }
}
