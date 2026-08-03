class MinStack {

    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack();
    }
    
    public void push(int val) {
        long v = val;
        if(!st.isEmpty()){
            if(v < min){
                long newVal = (2 * v) - min;
                min = v;
                st.push(newVal);
            }
            else{
                st.push(v);
            }
        }
        else{
            min = v;
            st.push(v); 
        }
    }
    
    public void pop() {
        if(st.peek() > min){
            st.pop();
        }
        else{
            long newMin = (2 * min) - st.peek();
            min = newMin;
            st.pop();
        }
    }
    
    public int top() {
        if(st.peek() < min) return (int) min;

        long top = st.peek();
        return (int) top;
    }
    
    public int getMin() {
        return (int) min;
    }
}
