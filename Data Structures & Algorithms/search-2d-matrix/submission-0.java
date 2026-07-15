class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m * n) - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int row = mid/n;
            int col = mid % n;

            int mid_val = matrix[row][col];

            if(mid_val == target) return true;
            else if(mid_val > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
