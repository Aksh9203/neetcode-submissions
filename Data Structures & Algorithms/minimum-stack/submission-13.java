class MinStack {
    Stack<int[]> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val,val});
        } else{
            int min = Math.min(val,st.peek()[1]);
            st.push(new int[]{val,min});
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }

        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}
