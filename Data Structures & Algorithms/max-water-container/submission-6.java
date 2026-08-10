class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int l = 0;
        int r = n - 1;

        int max = 0;
        int area = 0;

        while(l < r){
            if(heights[l] < heights[r]){
                area = heights[l] * (r - l);
                l++;
            }
            else{
                area = heights[r] * (r - l);
                r--;
            }
            max = Math.max(area,max);
        }
        return max;
    }
}
