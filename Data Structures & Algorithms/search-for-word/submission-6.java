class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dfs(board,word,i,j,0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int idx){
        if(idx == word.length()) return true;

        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(idx) || board[r][c] == '#'){
            return false;
        }

        board[r][c] = '#';

        boolean check = dfs(board,word,r+1,c,idx+1) ||
                        dfs(board,word,r-1,c,idx+1) ||
                        dfs(board,word,r,c+1,idx+1) ||
                        dfs(board,word,r,c-1,idx+1);

        board[r][c] = word.charAt(idx);
        return check;
    }
}
