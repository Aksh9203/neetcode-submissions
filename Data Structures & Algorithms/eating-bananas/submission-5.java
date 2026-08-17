class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 0;
        int high = 0;

        for(int i=0; i<n; i++){
            high = Math.max(high,piles[i]);
        }

        if(n == h) return high;
        int time = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(timeTaken(piles,mid) <= h){
                time = mid;
                high = mid - 1;
            } 
            else{
                low = mid + 1;
            }
        }
        return time;
    }

    private int timeTaken(int[] piles, int target){
        int n = piles.length;

        int hrs = 0;

        for(int pile : piles){
            hrs += Math.ceil((double)pile/target);
        }

        return hrs;
    }
}
