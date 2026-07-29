class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    int count = dfs(grid,i,j,n,m);
                    max = Math.max(max,count);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int r, int c, int n, int m){
        if(r<0 || r>=n || c<0 || c>=m || grid[r][c] == 0){
            return 0;
        }

        int count = 1;

        grid[r][c] = 0;

        count += dfs(grid,r+1,c,n,m);
        count += dfs(grid,r-1,c,n,m);
        count += dfs(grid,r,c+1,n,m);
        count += dfs(grid,r,c-1,n,m);

        return count;
    }
}
