/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newlist = new ListNode(0);
        
        ListNode p1=l1, p2=l2, p3=newlist;
        
        int carry=0, digit=0;
        
        while (p1 != null || p2 != null) {
            digit=(p1 != null ? p1.val:0) + (p2!=null? p2.val:0)+carry;
            carry= digit / 10;
            p3.next= new ListNode(digit % 10);
            
            if (p1 != null) p1=p1.next;
            if (p2 != null) p2=p2.next;
            p3=p3.next;   
        }
        if (carry == 1) p3.next=new ListNode(1);
        
        return newlist.next;
    }
}