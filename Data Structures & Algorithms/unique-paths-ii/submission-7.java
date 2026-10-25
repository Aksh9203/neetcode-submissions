class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] t = new int[n][m];

        if(obstacleGrid[0][0] == 1) return 0;

        for(int i=0; i<n; i++){
            if(obstacleGrid[i][0] == 1) break;
            t[i][0] = 1;
        }

        for(int j=0; j<m; j++){
            if(obstacleGrid[0][j] == 1) break;
            t[0][j] = 1;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(obstacleGrid[i][j] == 0){
                    t[i][j] = t[i-1][j] + t[i][j-1];
                } else {
                    t[i][j] = 0;
                }
                
            }
        }

        return t[n-1][m-1];

    }
}