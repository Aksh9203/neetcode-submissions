class Solution {
    public int maxArea(int[] heights) {
        int i = 0; 
        int j = heights.length - 1;
        int max = Integer.MIN_VALUE;
        int area = 0;

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
