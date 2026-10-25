class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(s.charAt(i),i);
        }

        int start = 0, end = 0;
        List<Integer> ls = new ArrayList<>();

        for(int i=0; i<n; i++){
            end = Math.max(end,mp.get(s.charAt(i)));

            if(i == end){
                ls.add(end - start + 1);
                start = end + 1;
            }
        }

        return ls;
    }
}
