class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int freshCnt = 0;
        Queue<int[]> q = new LinkedList<>();

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
            int time = top[2];

            maxTime = Math.max(maxTime,time);

            for(int i=0; i<4; i++){
                int newRow = row + travelRow[i];
                int newCol = col + travelCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 2;
                    freshCnt--;
                    q.add(new int[]{newRow,newCol,time + 1});
                }
            }
        }

        if(freshCnt > 0) return -1;

        return maxTime;
    }
}
