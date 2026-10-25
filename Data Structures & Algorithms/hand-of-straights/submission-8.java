class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        
        TreeMap<Integer,Integer> tMp = new TreeMap<>();
        for(int card : hand){
            tMp.put(card,tMp.getOrDefault(card,0) + 1);
        }

        while(tMp.size() > 0){
            int currCard = tMp.firstKey();

            for(int i=currCard; i<currCard+groupSize; i++){
                if (!tMp.containsKey(i)) return false;
                
                tMp.put(i,tMp.getOrDefault(i,0) - 1);
                int count = tMp.get(i);

                if(count < 1){
                    tMp.remove(i);
                }

                // if(i < currCard+groupSize && !tMp.containsKey(i + 1)) return false;
            }
        }
        return true;
    }
}
