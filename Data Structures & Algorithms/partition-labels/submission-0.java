class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        int[] lastOccur = new int[26];

        for(int i=0; i<n; i++){
            int letter = s.charAt(i) - 'a';
            lastOccur[letter] = i;
        }

        int i = 0;
        int j = 0;
        int end = 0;

        ArrayList<Integer> ls = new ArrayList<>();

        while(j<n){
            end = Math.max(end,lastOccur[s.charAt(j) - 'a']);

            if(j == end){
                ls.add(end - i + 1);
                i = j + 1;
            }
            j++;
        }
        return ls;
    }
}
