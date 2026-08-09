class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int start = 1;
        int end = 1;

        int maxProduct = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(start == 0) start = 1;
            if(end == 0) end = 1;

            start = start * nums[i];
            end = end * nums[n - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(start,end));
        }

        return maxProduct;
    }
}
