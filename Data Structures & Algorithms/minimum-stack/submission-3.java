class MinStack {
    Stack<Long> st;
    long min = Integer.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        long v = val;
        if(st.isEmpty()){
            min = v;
            st.push(min);
        }
        else{
            if(val < min){
                long newValue = (2 * v) - min;
                st.push(newValue);
                min = v;   
            }
            else{
                st.push(v);
            }
        }
    }
    
    public void pop() {
        if(st.peek() < min){
            long lastMin = (2 * min) - st.pop();
            min = lastMin;  
        }
        else{
            st.pop();
        }
    }
    
    public int top() {
        if(st.peek() < min){
            return (int) min;
        }
        else{
            long topVal = st.peek();
            return (int) topVal;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
