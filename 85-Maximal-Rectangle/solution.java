public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] heights = new int[m][n];
        
        
        //initialte the heights array
        for(int i = 0; i < m; i++) {
            for(int j = 0; j <n; j++) {
                if (i == 0) {
                    heights[i][j] = (matrix[i][j] == '1')? 1 : 0;
                } else {
                    heights[i][j] = (matrix[i][j] == '1')? heights[i-1][j]+1 : 0;
                }
            }
        }
        
        //count the maximum rectangle in every row
        int max = 0;
        for(int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j <= n; j++) {
                int curr = (j == n) ? -1 : heights[i][j];
                while (!stack.isEmpty() && curr <= heights[i][stack.peek()]) {
                    int h = heights[i][stack.pop()];
                    int w = (stack.isEmpty())? j : j - stack.peek() - 1;
                    max = Math.max(max, h * w);
                }
                stack.push(j);
            }
        }
        
        return max;
        
    }
}