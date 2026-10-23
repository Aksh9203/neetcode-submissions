class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(pile,high);
        }

        int minFruit = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(minTime(piles,mid) <= h){
                minFruit = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return minFruit;
    }

    private int minTime(int[] piles, int mid){
        int n = piles.length;
        int time = 0;

        for(int i=0; i<n; i++){
            time += Math.ceil((double)piles[i]/mid);
        }

        return time;
    }
}
