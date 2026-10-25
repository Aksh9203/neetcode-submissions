class Solution {
    public String longestPalindrome(String s) {
        int len = 0;
        int sIdx = 0;

        for(int i=0; i<s.length(); i++){
            int l = i, r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > len){
                    len = r - l + 1;
                    sIdx = l;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > len){
                    len = r - l + 1;
                    sIdx = l;
                }
                l--;
                r++;
            }

        }

        return s.substring(sIdx,sIdx+len);
        
    }
}
