class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String, List<String>> mp = new HashMap<>();
        // List<List<String>> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            String currWord = strs[i];
            // char[] ch = currWord.toCharArray();

            int[] freq = new int[26];

            for(char c : currWord.toCharArray()){
                freq[c - 'a']++;
            }

            // Arrays.sort(ch);
            String sortedWord = Arrays.toString(freq);

            if(!mp.containsKey(sortedWord)){
                mp.put(sortedWord, new ArrayList<>());
            } 
            mp.get(sortedWord).add(currWord);
        }
        // result.addAll(mp.values());

        return new ArrayList<>(mp.values());
    }
}
