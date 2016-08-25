public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int x=0, y=0;
        
        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    list.add(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    list.add(matrix[x++][y]);
                }
                break;
            }
            
            // top
            for (int i = 0; i < n-1; i++) {
                list.add(matrix[x][y++]);
            }
            
            //right
            for (int i = 0; i < m-1; i++) {
                list.add(matrix[x++][y]);
            }
            
            //bottom
            for (int i = 0; i < n-1; i++) {
                list.add(matrix[x][y--]);
            }
            
            //left
            for (int i = 0; i < m-1; i++) {
                list.add(matrix[x--][y]);
            }
            
            x++;
            y++;
            m -= 2;
            n -= 2;
        }
        
        return list;
    }
}