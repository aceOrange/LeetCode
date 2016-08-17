public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listSet = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0) {
            return listSet;
        }
        
        Arrays.sort(candidates);
        
        dfs(candidates, target, 0, listSet, list);
        
        return listSet;
    }
    
    public void dfs(int[] candidates, int target, int start, List<List<Integer>> listSet, List<Integer> list) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            listSet.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i-1] == candidates[i])  continue;
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i+1, listSet, list);
            list.remove(list.size() - 1);
        }
    }
}