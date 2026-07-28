class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<n; i++){
            if(tokens[i].equals("+")){
                int top1 = st.pop();
                int top2 = st.pop();

                int sum = top1 + top2;
                st.push(sum);
            }
            else if(tokens[i].equals("-")){
                int top1 = st.pop();
                int top2 = st.pop();

                int diff = top2 - top1;
                st.push(diff);
            }
            else if(tokens[i].equals("*")){
                int top1 = st.pop();
                int top2 = st.pop();

                int product = top2 * top1;
                st.push(product);
            }
            else if(tokens[i].equals("/")){
                int top1 = st.pop();
                int top2 = st.pop();

                int sub = top2/top1;
                st.push(sub);
            }
            else{
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
        }

        return st.pop();
    }
}
