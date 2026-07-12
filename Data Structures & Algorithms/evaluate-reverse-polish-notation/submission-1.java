class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            if(tokens[i].equals("+")){
                int val1 = st.pop();
                int val2 = st.pop();

                int sum = val1 + val2;
                st.push(sum);
            }
            else if(tokens[i].equals("*")){
                int val1 = st.pop();
                int val2 = st.pop();

                int mul = val1 * val2;
                st.push(mul);
            }
            else if(tokens[i].equals("-")){
                int val1 = st.pop();
                int val2 = st.pop();

                int diff = val2 - val1;
                st.push(diff);
            }
            else if(tokens[i].equals("/")){
                int val1 = st.pop();
                int val2 = st.pop();

                int div = val2/val1;
                st.push(div);
            }
            else {
                st.push(Integer.parseInt(tokens[i]));
            } 
        }

        return st.pop();
    }
}
