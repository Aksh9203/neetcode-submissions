class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] t = new int[n+1][m+1];

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m; j++){
                int res = path(matrix,i,j,-1,t);
                max = Math.max(max,res);
            }
        }

        return max;
        
    }

    public int path(int[][] matrix, int row, int col, int val, int[][] t){
        if(row<0 || col<0 || row>=matrix.length || col >= matrix[0].length || matrix[row][col] <= val ) return 0;

        if(t[row][col] != 0) return t[row][col];

        int res = 0;

        res = Math.max(res,1 + path(matrix,row+1,col,matrix[row][col],t));
        res = Math.max(res,1 + path(matrix,row,col+1,matrix[row][col],t));
        res = Math.max(res,1 + path(matrix,row-1,col,matrix[row][col],t));
        res = Math.max(res,1 + path(matrix,row,col-1,matrix[row][col],t));

        return t[row][col] = res;
    }
}
