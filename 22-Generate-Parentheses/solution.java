public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> listSet=new ArrayList<String>();
        addUp(n, 0, 0, new StringBuilder(), listSet);
        return listSet;
    }
    
    public void addUp(int n, int left, int right, StringBuilder str, List<String> listSet) {
        if (right > left) return;
        if (left == n) {
            while (right < n) {
                str.append(')');
                right++;
            }
        listSet.add(str.toString());
        }
        else if (left==right) {
            addUp(n, left+1, right, str.append('('), listSet);
        } else {
            int len=str.length();
            addUp(n, left+1, right, str.append('('), listSet);
            str.delete(len, str.length());
            addUp(n, left, right+1, str.append(')'), listSet);
        }
    }
}