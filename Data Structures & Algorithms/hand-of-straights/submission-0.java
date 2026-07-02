class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) return false;

        TreeMap<Integer,Integer> treeMp = new TreeMap<>();

        for(int i=0; i<n; i++){
            treeMp.put(hand[i],treeMp.getOrDefault(hand[i],0) + 1);
        }

        ArrayList<Integer> ls = new ArrayList<>();

        while(!treeMp.isEmpty()){
            int currCard = treeMp.firstKey();

            for(int i=0; i<groupSize; i++){
                int nextCard = currCard + i;

                if(!treeMp.containsKey(nextCard)) return false;

                ls.add(nextCard);
                int cnt = treeMp.get(nextCard);
                if(cnt == 1) treeMp.remove(nextCard);
                else treeMp.put(nextCard,cnt - 1);
            }
        }
        return true;
    }
}
