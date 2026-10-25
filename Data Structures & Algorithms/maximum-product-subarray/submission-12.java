class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int start = 1, end = 1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            start = start * nums[i];
            end = end * nums[n - i - 1];

            max = Math.max(max,Math.max(start,end));

            if(start == 0) start = 1;
            if(end == 0) end = 1;
        }
        return max;
    }
}
