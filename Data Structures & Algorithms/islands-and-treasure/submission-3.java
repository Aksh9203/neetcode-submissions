class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        int max = 2147483647;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[] delRow = {1,0,-1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty()){
            
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];

            for(int i = 0; i<4; i++){
                int r = delRow[i] + row;
                int c = delCol[i] + col;

                if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == max){
                    grid[r][c] = grid[row][col] + 1;
                    q.add(new int[]{r,c});
                }
            }
        }
    }
}
