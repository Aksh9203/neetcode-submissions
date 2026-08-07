class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid,i,j,n,m);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int row, int col, int n, int m){
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;

        int currentArea = 1;

        currentArea += dfs(grid,row+1,col,n,m);
        currentArea += dfs(grid,row-1,col,n,m);
        currentArea += dfs(grid,row,col+1,n,m);
        currentArea += dfs(grid,row,col-1,n,m);

        return currentArea;
    }
}
