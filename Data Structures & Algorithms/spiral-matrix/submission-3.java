class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int leftCol = 0;
        int rightCol = m - 1;
        int topRow = 0;
        int bottomRow = n - 1;

        List<Integer> ls = new ArrayList<>();

        while(leftCol <= rightCol && topRow <= bottomRow){

            for(int i = leftCol; i <= rightCol; i++){
                ls.add(matrix[topRow][i]);
            }
            topRow++;

            for(int i = topRow; i <= bottomRow; i++){
                ls.add(matrix[i][rightCol]);
            }
            rightCol--;

            if(topRow <= bottomRow){
                for(int i = rightCol; i >= leftCol ; i--){
                    ls.add(matrix[bottomRow][i]);
                }
                bottomRow--;
            }

            if(leftCol <= rightCol){
                for(int i = bottomRow; i >= topRow; i--){
                    ls.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }

        return ls;
    }
}
