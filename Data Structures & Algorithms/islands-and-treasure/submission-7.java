class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = Integer.MAX_VALUE;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[] travelRow = {1,0,-1,0};
        int[] travelCol = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] top = q.poll();
            int rowIdx = top[0];
            int colIdx = top[1];

            for(int i=0; i<4; i++){
                int rowDir = rowIdx + travelRow[i];
                int colDir = colIdx + travelCol[i];

                if(rowDir >= 0 && rowDir < n && colDir >= 0 && colDir < m && grid[rowDir][colDir] == max){
                    grid[rowDir][colDir] = grid[rowIdx][colIdx] + 1;
                    q.add(new int[]{rowDir,colDir});
                }
            }
        }
    }
}
