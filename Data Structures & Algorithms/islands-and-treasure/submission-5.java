class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[] dirRow = {1,0,-1,0};
        int[] dirCol = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] top = q.poll();
            int r = top[0];
            int c = top[1];

            for(int i=0; i<4; i++){
                int row = r + dirRow[i];
                int col = c + dirCol[i];

                if(row>=0 && row<n && col>=0 && col<m && grid[row][col] == 2147483647){
                    grid[row][col] = grid[r][c] + 1;
                    q.add(new int[]{row,col});
                }
            }
        }
    }
}
