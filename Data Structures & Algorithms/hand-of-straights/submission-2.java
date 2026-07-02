class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) return false;

        TreeMap<Integer,Integer> treeMp = new TreeMap<>();

        for(int i=0; i<n; i++){
            treeMp.put(hand[i],treeMp.getOrDefault(hand[i],0) + 1);
        }

        // ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while(!treeMp.isEmpty()){
            int currCard = treeMp.firstKey();

            // ArrayList<Integer> ls = new ArrayList<>();

            for(int i=0; i<groupSize; i++){
                int nextCard = currCard + i;

                if(!treeMp.containsKey(nextCard)) return false;

                // ls.add(nextCard);
                int cnt = treeMp.get(nextCard);
                if(cnt == 1) treeMp.remove(nextCard);
                else treeMp.put(nextCard,cnt - 1);
            }
            // res.add(ls);
        }
        return true;
    }
}
