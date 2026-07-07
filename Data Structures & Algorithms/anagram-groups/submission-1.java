class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String,List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String s = strs[i];
            char[] ch = s.toCharArray();

            Arrays.sort(ch);
            String sorted = Arrays.toString(ch);


            if(!mp.containsKey(sorted)){
                mp.put(sorted,new ArrayList<>());
            }
            mp.get(sorted).add(s);
        }

        return new ArrayList<>(mp.values());
    }
}
