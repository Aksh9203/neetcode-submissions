class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }

    public void  dfs(char[][] grid, int r, int c, int n, int m){
        if(r<0 || r>=n || c<0 || c>=m || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';

        dfs(grid,r+1,c,n,m);
        dfs(grid,r-1,c,n,m);
        dfs(grid,r,c+1,n,m);
        dfs(grid,r,c-1,n,m);
    }
}
