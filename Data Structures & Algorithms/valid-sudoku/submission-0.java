class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        int N = 9;

        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for(int i = 0; i<m; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();        
        }


        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){

                char value = board[r][c];

                if(value == '.'){
                    continue;
                }

                if(rows[r].contains(value)){
                    return false;
                }
                rows[r].add(value);

                if(cols[c].contains(value)){
                    return false;
                }
                cols[c].add(value);

                int boxNum = (r/3)*3 + c/3;
                if(boxes[boxNum].contains(value)){
                    return false;
                }
                boxes[boxNum].add(value);    
            }
        }
    return true;
    }
}
