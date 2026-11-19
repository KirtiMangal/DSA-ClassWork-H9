class Solution {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                   count++;

                    dfs(grid,i,j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid,int i, int j){
        int n= grid.length;
        int m= grid[0].length;

        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]!='1'){
            return;
        }

        grid[i][j]='0';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

}