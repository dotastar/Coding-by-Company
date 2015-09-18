//Find the longest word in a grid of random letter, each consecutive letters has to be next to the previous one.  
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        boolean res = dfs(board, word, index + 1, row + 1, col, visited) 
                    || dfs(board, word, index + 1, row - 1, col, visited)
                    || dfs(board, word, index + 1, row, col + 1, visited)
                    || dfs(board, word, index + 1, row, col - 1, visited);
        visited[row][col] = false;
        return res;
    }
}
