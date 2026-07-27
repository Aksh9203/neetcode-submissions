class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int i = 0;
        int j = n-1;
        
        int lmax = 0;
        int rmax = 0;
        int area = 0;

        while(i < j){
            if(height[i] <= height[j]){
                lmax = Math.max(lmax,height[i]);
                area += lmax - height[i];
                i++;
            }
            else{
                rmax = Math.max(rmax,height[j]);
                area += rmax - height[j];
                j--;
            }
        }
        return area;
    }
}
