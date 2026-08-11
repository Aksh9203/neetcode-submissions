class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        int nse = n;
        int pse = -1;
        int area = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int top = heights[st.pop()];

                if(st.isEmpty()){
                    pse = -1;
                }
                else{
                    pse = st.peek();
                }
                
                nse = i;
                area = top * (nse - pse - 1);
                max = Math.max(area,max);
            }
            st.push(i);
        }

        nse = n;

        while(!st.isEmpty()){
            int top = heights[st.pop()];

            if(st.isEmpty()){
                pse = -1;
            }
            else{
                pse = st.peek();
            }
            
            area = top * (nse - pse - 1);
            max = Math.max(area,max);
        }

        return max;
    }
}
