class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] t = new int[m][n];

        if(obstacleGrid[0][0] == 1) return 0;

        for(int i=0; i<m; i++){
            if(obstacleGrid[i][0] == 1) break;
            t[i][0] = 1;
        }

        for(int j=0; j<n; j++){
            if(obstacleGrid[0][j] == 1) break;
            t[0][j] = 1;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j] == 0){
                    t[i][j] = t[i-1][j] + t[i][j-1];
                }
                else{
                    t[i][j] = 0;
                }
            }
        }
        return t[m-1][n-1];
    }
}