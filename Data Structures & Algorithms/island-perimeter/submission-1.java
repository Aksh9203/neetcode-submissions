class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    return dfs(i,j,grid);
                }
            }
        }
        return 0;
    }

    public int dfs(int r, int c, int[][] grid){
        int cnt = 0;

        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == 0){
            return 1;
        }

        if(grid[r][c] == -1){
            return 0;
        }

        grid[r][c] = -1;

        cnt += dfs(r+1,c,grid);
        cnt += dfs(r-1,c,grid);
        cnt += dfs(r,c+1,grid);
        cnt += dfs(r,c-1,grid);

        return cnt;
    }
}