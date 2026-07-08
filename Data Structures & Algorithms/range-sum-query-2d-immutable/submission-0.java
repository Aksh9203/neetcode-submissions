class NumMatrix {

    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        prefix = new int[n+1][m+1];

        for(int i = 0; i<n; i++){
            int prefix_cnt = 0;
            for(int j = 0; j<m; j++){
                prefix_cnt = prefix_cnt + matrix[i][j];
                int above = prefix[i][j+1];
                prefix[i+1][j+1] = prefix_cnt + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 += 1;
        col1 += 1;
        row2 += 1;
        col2 += 1;

        int bottomRight = prefix[row2][col2];
        int above = prefix[row1 - 1][col2];
        int left = prefix[row2][col1 - 1];
        int topLeft = prefix[row1 - 1][col1 - 1];

        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */