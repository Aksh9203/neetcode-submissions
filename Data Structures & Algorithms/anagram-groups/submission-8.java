class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String,List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String str = strs[i];

            int[] freq = new int[26];

            for(char c : str.toCharArray()){
                freq[c - 'a']++;
            }

            String freqWord = Arrays.toString(freq);

            mp.computeIfAbsent(freqWord, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(mp.values());
    }
}
