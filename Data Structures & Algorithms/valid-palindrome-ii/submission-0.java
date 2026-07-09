class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();

        int i = 0;
        int j = n - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return pali(s,i + 1, j) || pali(s,i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean pali(String s, int i, int j){
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}