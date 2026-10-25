class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i=0; i<n; i++){
            dfs(heights,i,0,pacific,0);
            dfs(heights,i,m - 1,atlantic,0);
        }

        for(int j=0; j<m; j++){
            dfs(heights, 0, j, pacific,0);
            dfs(heights, n - 1, j, atlantic,0);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] freq, int prev){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || freq[r][c] == true || grid[r][c] < prev){
            return;
        }

        freq[r][c] = true;
        prev = grid[r][c];

        dfs(grid,r+1,c,freq,prev);
        dfs(grid,r-1,c,freq,prev);
        dfs(grid,r,c+1,freq,prev);
        dfs(grid,r,c-1,freq,prev);
    }
}
