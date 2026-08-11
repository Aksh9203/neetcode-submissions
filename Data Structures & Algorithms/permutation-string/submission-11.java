class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int[] s1Freq = new int[26];
        for(char c : s1.toCharArray()){
            s1Freq[c - 'a']++;
        }

        int[] s2Freq = new int[26];

        int l = 0, r = 0;

        while(r < m){
            s2Freq[s2.charAt(r) - 'a']++;
            
            if(r - l + 1 > n){
                s2Freq[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(s1Freq, s2Freq)) return true;
            r++;
        }
        return false;
    }
}
