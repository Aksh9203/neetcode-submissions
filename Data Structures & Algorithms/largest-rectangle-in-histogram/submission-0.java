class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int max = Integer.MIN_VALUE;
        int nse = n;
        int pse = -1;
        int area = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                nse = i;
                int top = heights[st.pop()];
                if(st.isEmpty()) pse = -1;
                else pse = st.peek();

                area = top * (nse - pse - 1);
                max = Math.max(max, area);
            }

            st.push(i);           
        }

        while(st.size() > 0){
            nse = n;
            int top = heights[st.pop()];
            if(st.isEmpty()) pse = -1;
            else pse = st.peek();

            area = top * (nse - pse - 1);
            max = Math.max(max, area);
        }

        return max;
    }
}
