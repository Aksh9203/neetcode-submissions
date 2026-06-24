class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int max = nums[0];

        for(int i=0; i<n; i++){
            int product = 1;
            for(int j=i; j<n; j++){
                product = nums[j]*product;
                max = Math.max(product,max);
            }
        }
        return max;
    }
}
