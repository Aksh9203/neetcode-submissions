class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        TreeMap<Integer,Integer> treeMp = new TreeMap<>();

        for(int handNum : hand){
            treeMp.put(handNum, treeMp.getOrDefault(handNum,0) + 1);
        }

        while(treeMp.size() > 0){
            int currCard = treeMp.firstKey();

            treeMp.put(currCard, treeMp.getOrDefault(currCard,0) - 1);
            int cnt = treeMp.get(currCard);
            if(cnt == 0) treeMp.remove(currCard);

            for(int i=1; i<groupSize; i++){
                int nextCard = currCard + i;

                if(!treeMp.containsKey(nextCard)){
                    return false;
                } 

                treeMp.put(nextCard, treeMp.getOrDefault(nextCard,0) - 1);
                int cnt1 = treeMp.get(nextCard);
                if(cnt1 == 0) treeMp.remove(nextCard);
            }
        }
        return true;
    }
}
