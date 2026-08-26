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

            System.out.println("List ::" + result);

            for(int i = topRow; i<= bottomRow; i++){
                result.add(matrix[i][rightCol]);
            }
            rightCol--;

            System.out.println("List ::" + result);

            if(topRow <= bottomRow){
                for(int i = rightCol; i>=leftCol; i--){
                    result.add(matrix[bottomRow][i]);
                }
                bottomRow--;
            }
            

            System.out.println("List ::" + result);

            if(leftCol <= rightCol){
                for(int i = bottomRow; i>= topRow; i--){
                    result.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
            
            System.out.println("List ::" + result);
        }

        return result;
    }
}
