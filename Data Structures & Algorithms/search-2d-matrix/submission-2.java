class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = (n*m) - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int row = mid / m;
            int col = mid % m;

            int midVal = matrix[row][col];

            if(midVal > target) high = mid - 1;
            else if(midVal < target) low = mid + 1;
            else{
                return true;
            }
        }
        
        return false;
    }
}
