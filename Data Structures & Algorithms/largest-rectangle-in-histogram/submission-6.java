class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        int nse = n, pse = -1;
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int top = st.pop();
                pse = st.isEmpty() ? -1 : st.peek();
                nse = i;
                maxArea = Math.max(maxArea,heights[top] * (nse - pse - 1)); 
            }
            st.push(i);
        }

        nse = n;
        while(!st.isEmpty()){
            int top = st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea,heights[top] * (nse - pse - 1));
        }

        return maxArea;
    }
}
