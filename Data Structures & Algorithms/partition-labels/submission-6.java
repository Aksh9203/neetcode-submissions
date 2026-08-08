class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        HashMap<Character,Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            mp.put(s.charAt(i),i);
        }

        int startPartition = 0;
        int endPartition = 0;

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            endPartition = Math.max(endPartition, mp.get(s.charAt(i)));

            if(i == endPartition){
                result.add(endPartition - startPartition + 1);
                startPartition = endPartition + 1;
            }
        }

        return result;
    }
}
