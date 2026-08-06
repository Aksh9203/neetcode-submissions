class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int[] freq = new int[26];
        int maxFreqCnt = 0;
        char maxFreqChar = ' ';

        for(int i=0; i<n; i++){
            freq[s.charAt(i) - 'a']++;
            if(freq[s.charAt(i) - 'a'] > maxFreqCnt){
                maxFreqCnt = freq[s.charAt(i) - 'a'];
                maxFreqChar = s.charAt(i);
            }

            if(maxFreqCnt > (n + 1)/2) return "";
        }

        char[] result = new char[n];
        int idx = 0;
        while(freq[maxFreqChar - 'a'] > 0){
            result[idx] = maxFreqChar;
            idx += 2;
            freq[maxFreqChar - 'a']--;
        }

        for(int i=0; i<n; i++){
            while(freq[s.charAt(i) - 'a'] > 0){
                if(idx >= n) idx = 1;

                result[idx] = s.charAt(i);
                idx += 2;
                freq[s.charAt(i) - 'a']--;
            }
        }

        return new String(result); 
    }
}