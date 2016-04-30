/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        
        int pos=1;
        ListNode prev=dummy, curr=head;
        while (curr!=null) {
            if (pos==k) {
                pos=0;
                prev=reverse(prev, curr);
                curr=prev.next;
            } else curr=curr.next;
            pos++;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode prev, ListNode end) {
        ListNode curr=prev.next;
        
        while (prev.next != end) {
            ListNode np=curr.next.next;
            curr.next.next=prev.next;
            prev.next=curr.next;
            curr.next=np;
        }
        
        return curr;
    }
}