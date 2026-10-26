class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    long sum = dfs(grid, visited, i, j);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, boolean[][] visited,
            int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j]= true;
        long sum = grid[i][j];

        sum += dfs(grid, visited, i, j + 1);
        sum += dfs(grid, visited, i-1, j );
        sum += dfs(grid, visited, i+1, j );
        sum += dfs(grid, visited, i, j - 1);

        return sum;

    }
}