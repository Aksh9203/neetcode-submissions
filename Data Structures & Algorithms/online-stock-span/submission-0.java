class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int spanCnt = 1;
        while(!st.isEmpty() && st.peek()[0] <= price){
            spanCnt += st.peek()[1];
            st.pop();
        }
        st.push(new int[]{price,spanCnt});
        return spanCnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */