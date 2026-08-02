class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int i = 0;
        int j = n - 1;

        int area = 0;
        int max = 0;

        while(i < j){
            if(heights[i] < heights[j]){
                area = heights[i] * (j - i);
                i++; 
            }
            else{
                area = heights[j] * (j - i);
                j--;
            }
            max = Math.max(area,max);
        }
        return max;
    }
}
