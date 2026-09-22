class Solution {

    int[][] directions = {
        {-1, 0},   // up
        {1, 0},    // down
        {0, -1},   // left
        {0, 1}     // right
    };

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        int n= board.length;
        int m= board[0].length;

       
        if (row < 0 || row >=n || col < 0 || col >=m) {
            return false;
        }

        
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

       
        if (index == word.length() - 1) {
            return true;
        }
        
        char temp = board[row][col];
        board[row][col] = '#';

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (dfs(board, word, newRow, newCol, index + 1)) {
                return true;
            }
        }

        board[row][col] = temp;

        return false;
    }
}