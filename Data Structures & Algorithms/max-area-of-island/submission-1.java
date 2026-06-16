class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt  = 0;
        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cnt  = dfs(i,j,grid);
                max = Math.max(max,cnt);
            }
        }
    return max;
    }

    public int dfs(int r, int c, int[][] grid){
        int cnt = 0;

        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == 0 || grid[r][c] == 2){
            return 0;
        }

        // grid[r][c] = 2;
        
        if(grid[r][c] == 1){
            grid[r][c] = 2;
            cnt++;
        }

        cnt += dfs(r+1,c,grid);
        cnt += dfs(r-1,c,grid);
        cnt += dfs(r,c+1,grid);
        cnt += dfs(r,c-1,grid);

        return cnt;
    }
}
