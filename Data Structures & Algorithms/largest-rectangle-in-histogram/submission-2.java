class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack();

        int max = 0;
        int area = 0;

        int nse = n;
        int pse = -1;

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int top = heights[st.pop()];

                nse = i;

                if(st.isEmpty()){
                    pse = -1;
                }
                else{
                    pse = st.peek();
                }

                area = top * (nse - pse - 1);
                max = Math.max(max,area);
            }
            st.push(i);  
        }

        while(!st.isEmpty()){
            nse = n;

            int top = heights[st.pop()];
            if(st.isEmpty()){
                pse = -1;
            }
            else{
                pse = st.peek();
            }

            area = top * (nse - pse - 1);
            max = Math.max(max , area);
        }

        return max;
    }
}
