//8queens O(2^n)
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] column = new int[n];
        placeQueens(0, n, column, res);
        return res;
    }
    
    public void placeQueens(int row, int n, int[] column, List<List<String>> res) {
        if (row == n) {
            List<String> c = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (column[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                c.add(sb.toString());
            }
            res.add(new ArrayList<String>(c));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (checkValid(column, row, col)) {
                column[row] = col;
                placeQueens(row + 1, n, column, res);    
            }
        }
    }
    
    public boolean checkValid(int[] column, int row, int col) {
        for (int r = 0; r < row; r++) {
            int c = column[r];
            if (col == c) {
                return false;
            }
            int colD = Math.abs(c - col);
            int rowD = row - r;
            if (colD == rowD) {
                return false;
            }
        }
        return true;
    }
}