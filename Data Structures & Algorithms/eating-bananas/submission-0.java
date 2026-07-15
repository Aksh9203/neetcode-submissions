class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 1;
        int high = 0;

        for(int i=0; i<n; i++){
            high = Math.max(piles[i],high);
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(totalTime(mid,piles) <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int totalTime(int k, int[] piles){
        int n = piles.length;
        int hrs = 0;

        for(int i=0; i<n; i++){
            hrs += Math.ceil((double)piles[i]/k);
        }

        return hrs;
    }
}
