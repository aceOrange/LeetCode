/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //corner case:
        if (headA == null || headB == null) {
            return null;
        }
        
        int lenA = findLength(headA);
        int lenB = findLength(headB);
        
        //make sure lenA < lenB
        if (lenA > lenB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        
        for (int i = 0; i < Math.abs(lenB - lenA); i++) {
            headB = headB.next;
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    public int findLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        
        return len;
    }
}