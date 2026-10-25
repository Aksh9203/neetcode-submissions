class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j,0});
                }
            }
        }


        int[] tRow = {1,0,-1,0};
        int[] tCol = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];
            int count = top[2];

            for(int i=0; i<4; i++){
                int r = row + tRow[i];
                int c = col + tCol[i];

                if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == max){
                    grid[r][c] = count + 1;
                    q.add(new int[]{r,c,count + 1});
                }
            }
        }
    }
}
