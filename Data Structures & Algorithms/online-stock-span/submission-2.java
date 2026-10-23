class StockSpanner {

    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int days = 1;

        while(!st.isEmpty() && price >= st.peek()[0]){
            days += st.peek()[1];
            st.pop();
        }

        st.push(new int[]{price,days});
        return st.peek()[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */