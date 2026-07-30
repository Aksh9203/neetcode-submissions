class Solution {
    public String reorganizeString(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();

        int[] freq = new int[26];
        int maxFreq = 0;
        char mostRepeatLetter = ' ';

        for(int i=0; i<n; i++){
            freq[ch[i] - 'a']++;
            if(freq[ch[i] - 'a'] > maxFreq){
                maxFreq = freq[ch[i] - 'a'];
                mostRepeatLetter = ch[i];
            }

            if(freq[ch[i] - 'a'] > (n + 1)/2) return "";
        }

        char[] result = new char[n];
        int idx = 0;

        while(freq[mostRepeatLetter - 'a'] > 0){
            result[idx] = mostRepeatLetter;
            idx += 2;
            freq[mostRepeatLetter - 'a']--;
        }

        for(char c = 'a'; c<='z'; c++){
            while(freq[c - 'a'] > 0){
                if(idx >= n) idx = 1;
                result[idx] = c;
                idx += 2;
                freq[c - 'a']--;
            }
        }

        return new String(result);
    }
}