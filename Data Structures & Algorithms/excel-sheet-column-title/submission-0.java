class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0){
            columnNumber--;
            int remainder = columnNumber % 26;
            // For 31:- remainder is 5, then A + 5 = F
            sb.append((char)('A' + remainder));
            // If num is 32 then it will become 1 which helps us to know that there is one more letter we can append.
            columnNumber = columnNumber/26;
        }

        return sb.reverse().toString();
    }
}