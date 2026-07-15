class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int  low = 0, high = 0;

        for(int i=0; i<n; i++){
            low = Math.max(weights[i],low);
            high += weights[i];
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(totalDays(mid,weights) <= days){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public int totalDays(int w, int[] weights){
        int n = weights.length;

        int days = 1;
        int current_w = 0;
        
        for(int i=0; i<n; i++){
            current_w += weights[i];
            if(current_w > w){
                days++;
                current_w = weights[i];
            }
        }
        return days;
    }
}