class MinStack {

    Stack<int[]> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(!st.isEmpty()){
            int min = st.peek()[1];
            if(val < min){
                st.push(new int[]{val,val});
            }
            else{
                st.push(new int[]{val,min});
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
        if(!st.isEmpty()){
            int top = st.peek()[0];
            return top;
        }

        return -1;
    }
    
    public int getMin() {
        int top = st.peek()[1];
        return top;
    }
}
