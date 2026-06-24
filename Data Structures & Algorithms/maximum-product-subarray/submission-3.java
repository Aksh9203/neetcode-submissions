class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // int max = nums[0];

        // for(int i=0; i<n; i++){
        //     int product = 1;
        //     for(int j=i; j<n; j++){
        //         product = nums[j]*product;
        //         max = Math.max(product,max);
        //     }
        // }
        // return max;

        int max = Integer.MIN_VALUE;

        int start = 1;
        int end = 1;

        for(int i=0; i<n; i++){

            if(start == 0) start = 1;
            if(end == 0) end = 1;

            start = start*nums[i];
            end = end*nums[n-1-i];

            max = Math.max(max,Math.max(start,end));
        }
        return max;
    }
}
