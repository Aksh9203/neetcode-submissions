class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    dfs(matrix,i,j,n,m);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == Integer.MAX_VALUE + 1){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    private void dfs(int[][] matrix, int row, int col, int n, int m){

        for(int i=0; i<m; i++){
            if(matrix[row][i] != 0){
                matrix[row][i] = Integer.MAX_VALUE + 1;    
            }
        }

        for(int i=0; i<n; i++){
            if(matrix[i][col] != 0){
                matrix[i][col] = Integer.MAX_VALUE + 1;    
            }
        }
    }
}
