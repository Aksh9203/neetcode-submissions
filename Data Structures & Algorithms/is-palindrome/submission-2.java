class Solution {
    public boolean isPalindrome(String s) {
        String newStr = s.replaceAll("[^a-zA-Z0-9]" , "").toLowerCase();

        int n = newStr.length();

        int l = 0;
        int r = n - 1;

        while(l < r){
            if(newStr.charAt(l) != newStr.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;

    }
}
