public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.0;
        }
        
        int len = nums1.length + nums2.length;
        
        if (len % 2 != 0) {
            return findKth(nums1, 0, nums2, 0, len/2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, len/2) + findKth(nums1, 0, nums2, 0, len/2 + 1)) / 2.0;
        }
    }
    
    public int findKth(int[] A, int m, int[] B, int n, int k) {
        if (m > A.length - 1) {
            return B[n + k - 1];
        }
        
        if (n > B.length - 1) {
            return A[m + k - 1];
        }
        
        if (k == 1) {
            return Math.min(A[m], B[n]);
        }
        
        int key_A = (m + k/2 <= A.length)? A[m + k/2 - 1] : Integer.MAX_VALUE;
        int key_B = (n + k/2 <= B.length)? B[n + k/2 - 1] : Integer.MAX_VALUE;
        
        if (key_A <= key_B) {
            return findKth(A, m + k/2, B, n, k - k/2);
        } else {
            return findKth(A, m, B, n + k/2, k - k/2);
        }
    }
}