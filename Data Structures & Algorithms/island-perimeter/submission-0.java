class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;
        // boolean[][] vis = new boolean[n][m]; 

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    cnt = dfs(i,j,grid);
                    // cnt++;
                }
            }
        }
        return cnt;
    }

    public int dfs(int r, int c,  int[][] grid){
        // vis[r][c] = true;

        if( r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0){
            return 1;
        }

        if (grid[r][c] == 2) return 0;

        grid[r][c]  = 2;

        int count = 0;
        count += dfs(r+1,c,grid);
        count += dfs(r-1,c,grid);
        count += dfs(r,c+1,grid);
        count += dfs(r,c-1,grid);
        return count;
    }
}