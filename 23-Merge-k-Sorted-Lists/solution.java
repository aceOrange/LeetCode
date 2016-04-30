/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public final Comparator<ListNode> PQ_ORDER = new Comparator<ListNode>() {
        public int compare(ListNode l1, ListNode l2) {
            if (l1.val < l2.val)    return -1;
            else if (l1.val > l2.val)   return 1;
            else                        return 0;
        }
    };
    
    public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length==0) return null;
    
    PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, PQ_ORDER);
    
    for (ListNode l: lists) {
        if (l != null) pq.add(l);
    }
    
    ListNode head=new ListNode(0);
    ListNode p=head;
    
    while (pq.size() > 0) {
        ListNode t=pq.poll();
        if (t.next != null)
            pq.add(t.next);
        p.next=t;
        p=p.next;
    }
    return head.next;   
    }
}