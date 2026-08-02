class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String, List<String>> mp = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            String s = strs[i];
            char[] c = s.toCharArray();

            Arrays.sort(c);

            String sorted = Arrays.toString(c);

            if(!mp.containsKey(sorted)){
                mp.put(sorted, new ArrayList<>());
            }
            mp.get(sorted).add(s);
        }
        result.addAll(mp.values());

        return result;
    }
}
