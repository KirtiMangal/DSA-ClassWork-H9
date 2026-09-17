class Solution {

    // STEP 1: Create the board
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, result, n);

        return result;
    }

    // STEP 2: Try placing a queen in every column
    private void solve(int row, char[][] board,
                       List<List<String>> result, int n) {

        // All queens have been placed
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            // STEP 3: Check if the position is safe
            if (isSafe(board, row, col, n)) {

                // Place the queen
                board[row][col] = 'Q';

                // Move to the next row
                solve(row + 1, board, result, n);

                // Backtrack: Remove the queen
                board[row][col] = '.';
            }
        }
    }

    // STEP 4: Check all three directions
    private boolean isSafe(char[][] board, int row,
                            int col, int n) {

        // Same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }

            i--;
            j--;
        }

        // Upper-right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }

            i--;
            j++;
        }

        return true;
    }

    // STEP 5: Convert the board into a list of strings
    private List<String> construct(char[][] board) {

        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(new String(row));
        }

        return list;
    }
}