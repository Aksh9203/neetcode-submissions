class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        if(n == 1) return false;

        Stack<Character> st = new Stack<>();

        for(int i = 0; i<n; i++){

            if(s.charAt(i) == '}'){
                if(st.contains('{') && st.peek() == '{'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else if(s.charAt(i) == ']'){
                if(st.contains('[') && st.peek() == '['){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else if(s.charAt(i) == ')'){
                if(st.contains('(') && st.peek() == '('){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else{
                st.push(s.charAt(i));
            }   
        }
        return st.size() > 0 ? false : true;
    }
}
