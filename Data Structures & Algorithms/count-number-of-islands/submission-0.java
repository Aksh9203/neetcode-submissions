class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){    
                    dfs(i,j,grid);
                    cnt++;
                }
            }
        }
    return cnt;
    }

    public void dfs(int r, int c, char[][]grid){

        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == '0' || grid[r][c] == '2'){
            return;
        }

        grid[r][c] = '2';

        // if(grid[r][c] == '1'){
        //     return 1;
        // }

        // grid[r][c] = '2';

        dfs(r+1,c,grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);

        // return cnt;

    }
}
