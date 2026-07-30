class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int low = 0, high = 0;

        for(int i=0; i<n; i++){
            high += weights[i];
            low = Math.max(low,weights[i]);
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(expectedDays(mid,weights) <= days){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int expectedDays(int target, int[] weights){
        int n = weights.length;

        int cnt = 1;
        int totalWeight = 0;

        for(int i=0; i<n; i++){
            totalWeight += weights[i];
            if(totalWeight > target){
                cnt++;
                totalWeight = weights[i];
            } 
        }

        return cnt;
    }
}