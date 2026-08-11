class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long v = (long) val;
        if(!st.isEmpty()){
            if(v < min){
                long newVal = (2*v) - min;
                min = v;
                st.push(newVal);
            }
            else{
                st.push(v);
            }
        }
        else{
            min = v;
            st.push(min);
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            if(st.peek() < min){
                long newMin = (2*min) - st.peek();
                min = newMin;
            }
            st.pop();
        }
        else{
            return;
        }
    }
    
    public int top() {
        long top = st.peek();
        if(st.peek() < min) return (int) min;
        return (int) top;
    }
    
    public int getMin() {
        return (int) min;
    }
}
