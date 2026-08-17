class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;

        int lMax = 0, rMax = 0;

        int maxArea = 0;

        while(l < r){
            if(height[l] <= height[r]){
                lMax = Math.max(lMax,height[l]);
                maxArea = maxArea + (lMax - height[l]);
                l++;
            }
            else{
                rMax = Math.max(rMax,height[r]);
                maxArea = maxArea + (rMax - height[r]);
                r--;
            }
        }
        return maxArea;
    }
}
