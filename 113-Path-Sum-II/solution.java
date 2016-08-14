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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> listSet = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        if (root == null) {
            return listSet;
        }
        
        dfs(listSet, list, root, sum);
        
        return(listSet);
    }
    
    public void dfs(List<List<Integer>> listSet, List<Integer> list, TreeNode root, int sum) {
        if (root == null)   return;
        
        sum -= root.val;
        
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                list.add(root.val);
                listSet.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            
            return;
        }
  
        list.add(root.val);
        dfs(listSet, list, root.left, sum);
        dfs(listSet, list, root.right, sum);
        list.remove(list.size() - 1);
        
    }
}