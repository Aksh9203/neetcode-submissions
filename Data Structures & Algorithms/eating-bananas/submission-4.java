class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 0, high = 0;

        for(int i=0; i<n; i++){
            high = Math.max(piles[i],high);
        }

        if(n == h) return high;

        int minBananas = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(minTime(piles,mid) <= h){
                minBananas = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return minBananas;
    }

    public int minTime(int[] piles, int target){
        int n = piles.length;
        int timeTaken = 0;

        for(int i=0; i<n; i++){
            timeTaken += Math.ceil((double)piles[i]/target);
        }
        return timeTaken;
    }
}
