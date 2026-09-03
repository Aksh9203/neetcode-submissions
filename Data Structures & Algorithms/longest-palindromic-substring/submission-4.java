class Solution {
    public String longestPalindrome(String s) {
        int subLen = 0;
        int subIdx = 0;

        for(int i=0; i<s.length(); i++){
            int l = i, r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > subLen){
                    subLen = r - l + 1;
                    subIdx = l;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > subLen){
                    subLen = r - l + 1;
                    subIdx = l;
                }

                l--;
                r++;
            }
        }

        return s.substring(subIdx, subIdx + subLen);
    }
}
