class MinStack {
    Stack<int[]> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(!st.isEmpty()){
            if(val < st.peek()[1]){
                st.push(new int[]{val,val});
            }
            else{
                st.push(new int[]{val,st.peek()[1]});
            }
        }
        else{
            st.push(new int[]{val,val});
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
        else{
            return;
        }
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}
