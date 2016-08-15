public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (k <= 0) {
            return 0;
        }
        
        return findKth(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    
    public int findKth(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int position = partition(nums, l, r);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 > k) {
            return findKth(nums, l, position - 1, k);
        } else {
            return findKth(nums, position + 1, r, k);
        }
    }
    
    //partition the array by making nums[l] as the pivot point
    public int partition(int[] nums, int l, int r) {
        int left = l, right = r;
        int pivot = nums[left];
        
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        
        return left;
    }
}