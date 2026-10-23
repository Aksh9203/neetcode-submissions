class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int weight : weights){
            low = Math.max(weight,low);
            high += weight;
        }

        int minWeight = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(minDays(weights,mid) <= days){
                minWeight = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return minWeight;
    }

    private int minDays(int[] weights, int target){
        int n = weights.length;
        int days = 1;
        int totalWeights = 0;

        for(int weight : weights){
            totalWeights += weight;
            if(totalWeights > target){
                days++;
                totalWeights = weight;
            }
        }

        return days;
    }
}