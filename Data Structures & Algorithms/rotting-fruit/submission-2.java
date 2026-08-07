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
                else if(grid[i][j] == 1){
                    freshCnt++;
                }
            }
        }

        if(freshCnt == 0) return 0;

        int[] travelRow = {1,0,-1,0};
        int[] travelCol = {0,1,0,-1};

        int maxTime = 0;

        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];
            int currTime = top[2];

            maxTime = Math.max(currTime, maxTime);

            for(int i=0; i<4; i++){
                int rowDir = row + travelRow[i];
                int colDir = col + travelCol[i];

                if(rowDir >= 0 && rowDir < n && colDir >=0 && colDir < m && grid[rowDir][colDir] == 1){
                    freshCnt--;
                    grid[rowDir][colDir] = 2;
                    q.add(new int[]{rowDir,colDir,currTime+1});
                }
            }
        }

        if(freshCnt > 0) return -1;

        return maxTime;
    }
}
