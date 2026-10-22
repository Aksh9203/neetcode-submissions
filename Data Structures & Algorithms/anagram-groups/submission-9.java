class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String s = strs[i];

            char[] ch = s.toCharArray();

            int[] freq = new int[26];
            for(char c : ch){
                freq[c - 'a']++;
            }

            String newStr = Arrays.toString(freq);

            mp.computeIfAbsent(newStr, k -> new ArrayList()).add(s);
        }

        return new ArrayList<>(mp.values());
    }
}
