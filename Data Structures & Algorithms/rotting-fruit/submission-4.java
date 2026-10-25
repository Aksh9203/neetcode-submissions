class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0});
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;
        int maxTime = 0;

        int[] tRow = {1,0,-1,0};
        int[] tCol = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];
            int time = top[2];

            maxTime = Math.max(maxTime,time);

            for(int i=0; i<4; i++){
                int r = row + tRow[i];
                int c = col + tCol[i];

                if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1){
                    grid[r][c] = 2;
                    fresh--;
                    q.add(new int[]{r,c,time + 1});
                }
            }
        }

        return fresh == 0 ? maxTime : -1;
        
    }
}
