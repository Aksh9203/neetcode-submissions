class MinStack {

    Stack<int[]> st;
    int min;
    public MinStack() {
        st = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.size() > 0){
            if(val < st.peek()[1]){
                min = val;
                st.push(new int[]{val,min});
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
        st.pop();
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek()[0];
        }
        else return 0;
    }
    
    public int getMin() {
        int[] top = st.peek();
        return top[1];
    }
}
