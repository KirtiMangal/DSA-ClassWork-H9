class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        char[] ch = word.toCharArray();  

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(board[i][j] == ch[0]){  
                    if(dfs(board, i, j, m, n, ch, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int m, int n, char[] ch, int idx){

       
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != ch[idx]){
            return false;
        }

       
        if(idx == ch.length - 1){
            return true;
        }

        
        char temp = board[i][j];
        board[i][j] = '#';

        
        boolean found =
            dfs(board, i+1, j, m, n, ch, idx+1) ||
            dfs(board, i-1, j, m, n, ch, idx+1) ||
            dfs(board, i, j+1, m, n, ch, idx+1) ||
            dfs(board, i, j-1, m, n, ch, idx+1);

        board[i][j] = temp;
        return found;
    }
}