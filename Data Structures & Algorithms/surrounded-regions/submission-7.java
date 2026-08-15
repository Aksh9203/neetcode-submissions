class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            dfs(board,i,0,m,n);
            dfs(board,i,n-1,m,n);
        }

        for(int j=0; j<n; j++){
            dfs(board,0,j,m,n);
            dfs(board,m-1,j,m,n);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }

    }
    
    public void dfs(char[][] board, int row, int col, int m , int n){
        if(row < 0 || row >= m || col < 0 || col >= n || board[row][col] == 'X' || board[row][col] == '#'){ 
            return; 
        }

        board[row][col] = '#';

        dfs(board,row + 1,col,m,n);
        dfs(board,row - 1,col,m,n);
        dfs(board,row,col + 1,m,n);
        dfs(board,row,col - 1,m,n);
    }
}
