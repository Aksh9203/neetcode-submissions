class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(char[][] grid, int row, int col){
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0' || grid[row][col] == '#'){
            return;
        }

        grid[row][col] = '#';

        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}
