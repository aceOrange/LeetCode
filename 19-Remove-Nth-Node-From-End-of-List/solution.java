/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*public static class ListNode 
	{
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}*/
	
	public static ListNode removeNthFromEnd(ListNode head, int n) 
	{
		ListNode prev=head, curr=head;
		int gap=n;
		
		while (curr != null)
		{
			if (gap >= 0)
				gap--;
			else prev=prev.next;
			curr=curr.next;
		}
		if (gap==0) return head.next;
		else prev.next=prev.next.next;
		
		return head;
	}
}