/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        
        dummy.next=head;
        ListNode prev = dummy, curr=head;
        
        while (curr != null && curr.next != null)
        {
            ListNode nt;
            nt=curr.next.next;
            curr.next.next=prev.next;
            prev.next=curr.next;
            curr.next=nt;
            
            prev=curr;
            curr=curr.next;
        }
        
        return dummy.next;
    }
}