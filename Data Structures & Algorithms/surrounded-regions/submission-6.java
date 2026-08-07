class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            dfs(board,i,0);
            dfs(board,i,m-1);
        }

        for(int j=0; j<m; j++){
            dfs(board,0,j);
            dfs(board,n-1,j);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col){
        int n = board.length;
        int m = board[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m || board[row][col] == '#' || board[row][col] == 'X'){
            return;
        } 

        board[row][col] = '#';

        dfs(board,row+1,col);
        dfs(board,row-1,col);
        dfs(board,row,col + 1);
        dfs(board,row,col - 1);
    }
}
