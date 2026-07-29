class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dfs(board,word,i,j,n,m,0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int r, int c, int n, int m, int idx){
        if(idx == word.length()) return true;

        if(r < 0 || r >= n || c < 0  || c >= m || board[r][c] == '#' || board[r][c] != word.charAt(idx)){
            return false;
        }

        board[r][c] = '#';

        boolean check = dfs(board,word,r+1,c,n,m,idx+1) ||
                        dfs(board,word,r-1,c,n,m,idx+1) ||
                        dfs(board,word,r,c+1,n,m,idx+1) ||
                        dfs(board,word,r,c-1,n,m,idx+1);

        board[r][c] = word.charAt(idx);

        return check;
    }
}
