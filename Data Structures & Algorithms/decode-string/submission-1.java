class Solution {
    public String decodeString(String s) {
        Stack<String> prevStr = new Stack<>();
        Stack<Integer> num = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int k = 0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }
            else if(c == '['){
                prevStr.push(sb.toString());
                sb = new StringBuilder();
                num.push(k);
                k = 0;
            }
            else if(c == ']'){
                String currStr = sb.toString();
                sb = new StringBuilder(prevStr.pop());
                int cnt = num.pop();

                for(int i=0; i<cnt; i++){
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