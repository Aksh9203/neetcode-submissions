class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 1;
        int high = 0;

        for(int i=0; i<n; i++){
            high = Math.max(high,piles[i]);
        }

        if(n == h) return high;

        int minFruit = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(eatingTime(piles,mid) <= h){
                minFruit = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return minFruit;
    }

    public int eatingTime(int[] piles, int target){
        int hrs = 0;

        for(int i=0; i<piles.length; i++){
            hrs += Math.ceil((double)piles[i]/target);
        }
        return hrs;
    }
}
