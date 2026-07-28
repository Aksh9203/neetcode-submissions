class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        int max = Integer.MIN_VALUE;
        int nse = n;
        int pse = -1;

        int area = 0;

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                nse = i;
                int top = st.pop();
                if(st.isEmpty()){
                    pse = -1;
                }
                else{
                    pse = st.peek();
                }
                area = heights[top] * (nse - pse - 1);
                max = Math.max(max,area);
            }
            st.push(i);
        }

        nse = n;

        while(st.size() > 0){
            int top = st.pop();
            if(st.isEmpty()){
                pse = -1;
            }
            else{
                pse = st.peek();
            }
            area = heights[top] * (nse - pse - 1);
            max = Math.max(max,area);
        }

        return max;
    }
}
