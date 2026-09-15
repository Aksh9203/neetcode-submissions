class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        HashSet<Integer>[] row = new HashSet[n];
        HashSet<Integer>[] col = new HashSet[n];
        HashSet<Integer>[] box = new HashSet[n];

        for(int i=0; i<n; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int val = board[i][j];

                if(val == '.'){
                    continue;
                }

                if(row[i].contains(val)){
                    return false;
                }
                row[i].add(val);

                if(col[j].contains(val)){
                    return false;
                }
                col[j].add(val);

                int newVal = (i/3 * 3) + j/3;
                if(box[newVal].contains(val)){
                    return false;
                }
                box[newVal].add(val);
            }
        }

        return true;
    }
}
