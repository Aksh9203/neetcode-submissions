class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int leftCol = 0;
        int rightCol = m - 1;
        int topRow = 0;
        int bottomRow = n - 1;

        List<Integer> result = new ArrayList<>();

        while(topRow <= bottomRow && leftCol <= rightCol){
            for(int i = leftCol; i<= rightCol; i++){
                result.add(matrix[topRow][i]);
            }
            topRow++;

            for(int i = topRow; i<= bottomRow; i++){
                result.add(matrix[i][rightCol]);
            }
            rightCol--;


            // Put if condition so, if topRow already crosses the bottomRow then no need to check for the element
            // That means all the elements for the row is traverse. Now check for remaining element in column.
            if(topRow <= bottomRow){
                for(int i = rightCol; i>=leftCol; i--){
                    result.add(matrix[bottomRow][i]);
                }
                bottomRow--;
            }

            // Put if condition so, if leftCol already crosses the rightCol then no need to check for the element
            // That means all the elements for the column is traverse. Now check for remaining element in row.
            if(leftCol <= rightCol){
                for(int i = bottomRow; i>= topRow; i--){
                    result.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }

        return result;
    }
}
