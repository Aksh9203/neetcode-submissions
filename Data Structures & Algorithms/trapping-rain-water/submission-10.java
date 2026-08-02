class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int i = 0;
        int j = n - 1;
        int rMax = 0;
        int lMax = 0;

        int area = 0;

        while(i < j){
            if(height[i] < height[j]){
                lMax = Math.max(lMax,height[i]);
                area += lMax - height[i];
                i++;
            }
            else{
                rMax = Math.max(rMax,height[j]);
                area += rMax - height[j];
                j--;
            }
        }
        return area;
    }
}
