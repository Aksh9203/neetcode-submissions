class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        HashMap<Character,Integer> mp = new HashMap<>();
        int maxLen = 0;

        int  l = 0, r = 0;

        while(r < n){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r),0) + 1);
            while(mp.get(s.charAt(r)) > 1){
                    mp.put(s.charAt(l), mp.getOrDefault(s.charAt(l),0) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
