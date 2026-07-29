class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(char[] c : board){
            Arrays.fill(c,'.');
        }

        int[] left = new int[n];
        int[] upperD = new int[2*n - 1];
        int[] lowerD = new int[2*n - 1];    

        solve(0,left,upperD,lowerD,ans,n,board);

        return ans;
    }

    public void solve(int col, int[] left, int[] upperD, int[] lowerD, List<List<String>> ans, int n, char[][] board){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }


        for(int row = 0; row<n; row++){
            //Safety
            if(left[row] == 0 && upperD[(n-1) + (col - row)] == 0 && lowerD[row + col] == 0){

                //Place Queen
                board[row][col] = 'Q';
                left[row] = 1;
                upperD[(n-1) + (col - row)] = 1;
                lowerD[row + col] = 1;

                //Check at other columns
                solve(col+1, left, upperD, lowerD, ans, n, board);

                //Remove Queen from the column
                board[row][col] = '.';
                left[row] = 0;
                upperD[(n-1) + (col - row)] = 0;
                lowerD[row + col] = 0;
            }
        }
    }
}
