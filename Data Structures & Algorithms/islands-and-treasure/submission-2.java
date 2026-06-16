class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 2147483647){
                    grid[i][j] = -2;
                }
            }
        }

        int[] delR = {1,0,-1,0};
        int[] delC = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] top = q.poll();

            int row = top[0];
            int col = top[1];

            for(int j = 0; j<4; j++){
                int r = row + delR[j];
                int c = col + delC[j];

                if(r>=0 && r<n && c>=0 && c<m && grid[r][c] == -2){
                    grid[r][c] = grid[row][col] + 1;
                    q.add(new int[]{r,c});
                }
            }
        }
        return;
    }
}
