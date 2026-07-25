class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = 0;
        int count = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    count = dfs(grid, i, j);
                    max = Math.max(max,count);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int row, int col){
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0 || grid[row][col] == 2){
            return 0;
        }

        int cnt = 1;
        grid[row][col] = 2;

        cnt += dfs(grid, row + 1, col);
        cnt += dfs(grid, row - 1, col);
        cnt += dfs(grid, row, col + 1);
        cnt += dfs(grid, row, col - 1);

        return cnt;
    }
}
