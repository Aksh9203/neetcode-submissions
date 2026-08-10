class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int l = 0;
        int r = n - 1;
        int area = 0;
        int lMax = 0, rMax = 0;

        while(l < r){
            if(height[l] < height[r]){
                lMax = Math.max(lMax,height[l]);
                area = area + (lMax - height[l]);
                l++;
            }
            else{
                rMax = Math.max(rMax,height[r]);
                area = area + (rMax - height[r]);
                r--;
            }
        }
        return area;
    }
}
