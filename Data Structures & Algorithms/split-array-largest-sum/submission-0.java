class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        long low = 0, high = 0;

        for(int i = 0; i<n; i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        long ans = 0;

        while(low <= high){
            long mid = low + (high - low)/2;

            if(minSum(mid,nums) <= k){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return (int) ans;
    }

    public int minSum(long k, int[] nums){
        int n = nums.length;

        int cnt = 1;
        int total = 0;

        for(int i=0; i<n; i++){
            total += nums[i];
            if(total > k){
                cnt++;
                total = nums[i];
            }
        }

        return cnt;

    }
}