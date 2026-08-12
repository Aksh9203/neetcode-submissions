class Solution {
    public String decodeString(String s) {
        int n = s.length();

        Stack<String> prevStr = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }
            else if(c == '['){
                prevStr.push(sb.toString());
                numStack.push(k);
                k = 0;
                sb = new StringBuilder();
            }
            else if(c == ']'){
                StringBuilder currStr = new StringBuilder(sb);
                sb = new StringBuilder(prevStr.pop());
                int count = numStack.pop();

                for(int i=0; i<count; i++){
                    sb.append(currStr);
                }
            }
            else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}