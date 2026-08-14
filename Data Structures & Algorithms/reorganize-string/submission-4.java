class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int[] freq = new int[26];
        char maxFreqChar = ' ';
        int maxFreq = 0;

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
            if(freq[c - 'a'] > maxFreq){
                maxFreq = freq[c - 'a'];
                maxFreqChar = c;
            }

            if(maxFreq > (n + 1)/2) return "";
        }

        int idx = 0;
        char[] res = new char[n];

        while(freq[maxFreqChar - 'a'] > 0){
            res[idx] = maxFreqChar;
            freq[maxFreqChar - 'a']--;
            idx = idx + 2;
        }

        for(int i=0; i<n; i++){
            while(freq[s.charAt(i) - 'a'] > 0){
                if(idx >= n) idx = 1;
                res[idx] = s.charAt(i);
                freq[s.charAt(i) - 'a']--;
                idx = idx + 2;
            }
        }

        return new String(res);

    }
}