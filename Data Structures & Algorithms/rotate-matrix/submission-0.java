class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] copy = new int[m][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy[j][i] = matrix[i][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][n - j - 1] = copy[i][j];
            }
        }
    }
}
