/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode= new ListNode(0);
        ListNode p = dummyNode;
        
        ListNode p1=l1,p2=l2;
        while (p1 != null && p2 != null)
        {
            if(p1.val < p2.val)
            {
                p.next=p1;
                p1=p1.next;
            } 
            else
            {
                p.next=p2;
                p2=p2.next;
            }
        
            p=p.next;
        }
        if (p1 != null) p.next=p1;
        if (p2 != null) p.next=p2;
            
        return dummyNode.next;
    }
}