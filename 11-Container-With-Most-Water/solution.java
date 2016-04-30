public class Solution {
    public int maxArea(int[] height) {
        int lo=0, hi=height.length-1, max=0;
        int area;
        while (lo<hi) {
            area=Math.min(height[lo], height[hi])*(hi-lo);
            if (area>max) max=area;
            if (height[lo]<height[hi]) lo++;
            else                       hi--;
        }
        
        return max;
    }
}