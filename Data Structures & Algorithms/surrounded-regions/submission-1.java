class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board);
            }           
        }

        for(int j=0; j<m; j++){
            if(board[0][j] == 'O'){
                dfs(0,j,board);
            } 
        }

        for(int i=0; i<n; i++){
            if(board[i][m-1] == 'O'){
                dfs(i,m-1,board);
            } 
        }

        for(int j=0; j<m; j++){
            if(board[n-1][j] == 'O'){
                dfs(n-1,j,board);
            } 
        }

        for(int k = 0; k < n; k++) {
            for(int a = 0; a < m; a++) {
                if(board[k][a] == 'O') {
                    board[k][a] = 'X';
                }
                else if(board[k][a] == '#'){
                    board[k][a] = 'O';
                }
            }
        }
    return;
    }

    public void dfs(int r, int c, char[][] board){

        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c] == 'X' || board[r][c] == '#'){
            return;
        }

        board[r][c] = '#';

        dfs(r+1,c,board);
        dfs(r-1,c,board);
        dfs(r,c+1,board);
        dfs(r,c-1,board);
    }
}
