class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int low = 0, high = 0;

        for(int i=0; i<n; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        int minWeights = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(totalDays(weights,mid) <= days){
                minWeights = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return minWeights;
    }

    public int totalDays(int[] weights, int weight){
        int n = weights.length;
        int daysCnt = 1;

        int totalWeight = 0;

        for(int i=0; i<n; i++){
            totalWeight += weights[i];
            if(totalWeight > weight){
                daysCnt++;
                totalWeight = weights[i];
            }
        }

        return daysCnt++;
    }
}