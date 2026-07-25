class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int freshCnt = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0});
                }
                else if(grid[i][j] == 1) freshCnt++;
            }
        }

        int[] delRow = {1,0,-1,0};
        int[] delCol = {0,1,0,-1};
        int maxTime = 0;

        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];
            int time = top[2];

            maxTime = Math.max(maxTime,time); 

            for(int i=0; i<4; i++){
                int r = delRow[i] + row;
                int c = delCol[i] + col;

                if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1){
                    grid[r][c] = 2;
                    q.add(new int[]{r,c,time + 1});
                    freshCnt--;
                }
            }
        }

        if(freshCnt > 0) return -1;

        return maxTime;
    }
}
