class Solution {
    public String decodeString(String s) {
        Stack<String> str = new Stack<>();
        Stack<Integer> num = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int k = 0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }
            else if(c == '['){
                str.push(sb.toString());
                num.push(k);
                sb = new StringBuilder();
                k=0;
            }
            else if(c == ']'){
                String newStr = sb.toString();
                sb = new StringBuilder(str.pop());
                int cnt = num.pop();

                for(int i=0; i<cnt; i++){
                    sb.append(newStr);
                }
            }
            else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}