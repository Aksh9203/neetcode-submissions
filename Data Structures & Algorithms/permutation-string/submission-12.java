class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int[] freq = new int[26];
        for(char c : s1.toCharArray()){
            freq[c - 'a']++;
        }

        int[] freq1 = new int[26];

        int l = 0, r = 0;

        while(r < m){
            freq1[s2.charAt(r) - 'a']++;

            if((r - l + 1) > n){
                freq1[s2.charAt(l) - 'a']--;
                l++;
            }

            if(Arrays.equals(freq,freq1)) return true;
            r++;
        }

        return false;
    }
}
