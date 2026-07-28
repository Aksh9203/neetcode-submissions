class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 1;
        int high = 0;

        for(int pile : piles){
            high = Math.max(high,pile);
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(eat(mid,piles) <= h){
                high = mid - 1;
                ans = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int eat(int h, int[] piles){
        int n = piles.length;
        
        int time = 0;
        for(int i=0; i<n; i++){
            time += Math.ceil((double) piles[i]/h);
        }

        return time;
    }
}
