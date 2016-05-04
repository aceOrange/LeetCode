/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        inorder(root, q);
        
        TreeNode node1=null, node2=null;
        while (!q.isEmpty()) {
            TreeNode prev=q.poll();
            while (!q.isEmpty()) {
                TreeNode curr=q.poll();
                if (prev.val > curr.val) {
                    if (node1 == null){
                        node1=prev;
                        node2=curr;
                    } else {
                        node2=curr;
                        break;
                    }
                }
                prev=curr;
            }
        }
        swap(node1, node2);
    }
    public void inorder(TreeNode root, Queue<TreeNode> q) {
        if (root == null) return;
        if (root.left != null) inorder(root.left, q);
        q.add(root);
        if (root.right != null) inorder(root.right, q);
    }
    
    public void swap(TreeNode a, TreeNode b) {
        if (a==null || b==null) return;
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
    }
}