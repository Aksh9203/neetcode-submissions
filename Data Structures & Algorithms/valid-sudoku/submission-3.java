class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        HashSet<Character>[] row = new HashSet[n];
        HashSet<Character>[] col = new HashSet[n];
        HashSet<Character>[] box = new HashSet[n];

        for(int i=0; i<n; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                char value = board[r][c];

                if(value == '.') continue;

                if(row[r].contains(value)) return false;
                row[r].add(value);

                if(col[c].contains(value)) return false;
                col[c].add(value);

                int boxN = (r/3 * 3) + (c/3);
                if(box[boxN].contains(value)) return false;

                box[boxN].add(value);
            }
        }
        return true;
    }
}
