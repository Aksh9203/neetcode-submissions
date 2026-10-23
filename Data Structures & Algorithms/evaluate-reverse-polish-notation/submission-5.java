class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> st = new Stack<>();

        for(String token : tokens){
            if(token.equals("+")){
                int val1 = st.pop();
                int val2 = st.pop();

                int val = val1 + val2;
                st.push(val);
            } else if(token.equals("-")){
                int val1 = st.pop();
                int val2 = st.pop();

                int val = val2 - val1;
                st.push(val);
            } else if(token.equals("*")){
                int val1 = st.pop();
                int val2 = st.pop();

                int val = val1 * val2;
                st.push(val);
            } else if(token.equals("/")){
                int val1 = st.pop();
                int val2 = st.pop();

                int val = val2/val1;
                st.push(val);
            } else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
