//Spiral Matrix
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = -1;
        while (true) {
            for (int i = 0; i < n; i++) {
                res.add(matrix[row][++col]);
            }
            if (--m == 0) {
                break;
            }
            for (int i = 0; i < m; i++) {
                res.add(matrix[++row][col]);
            }
            if (--n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                res.add(matrix[row][--col]);
            }
            if (--m == 0) {
                break;
            }
            for (int i = 0; i < m; i++) {
                res.add(matrix[--row][col]);
            }
            if (--n == 0) {
                break;
            }
        }
        return res;
    }
}