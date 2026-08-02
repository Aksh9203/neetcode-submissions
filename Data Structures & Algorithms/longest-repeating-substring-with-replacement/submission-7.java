class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int l = 0, r = 0;

        HashMap<Character,Integer> mp = new HashMap<>();
        int maxFreq = 0, maxLen = 0;

        while(r < n){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r),0) + 1);
            maxFreq = Math.max(maxFreq, mp.get(s.charAt(r)));
            if((r - l + 1) - maxFreq > k){
                mp.put(s.charAt(l), mp.getOrDefault(s.charAt(l),0) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
