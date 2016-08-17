public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = -1;
        int n;
        
        while (true) {
            for (n = 0; n < col; n++)   list.add(matrix[i][++j]);
            if (--row == 0) break;
            
            for (n = 0; n < row; n++)   list.add(matrix[++i][j]);
            if (--col == 0) break;
            
            for (n = 0; n < col; n++)   list.add(matrix[i][--j]);
            if (--row == 0) break;
            
            for (n = 0; n < row; n++)   list.add(matrix[--i][j]);
            if (--col == 0) break;
        }
        
        return list;
    }
}