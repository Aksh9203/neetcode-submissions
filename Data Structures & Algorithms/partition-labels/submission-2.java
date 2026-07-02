class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        int[] lastOccur = new int[26];

        for(int i=0; i<n; i++){ 
            lastOccur[s.charAt(i) - 'a'] = i;
        }

        int i = 0;
        int start = 0;
        int end = 0;

        ArrayList<Integer> ls = new ArrayList<>();

        while(i<n){
            end = Math.max(end,lastOccur[s.charAt(i) - 'a']);

            if(i == end){
                ls.add(end - start + 1);
                start = i + 1;
            }
            i++;
        }
        return ls;
    }
}
