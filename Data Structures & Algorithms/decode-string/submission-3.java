class Solution {
    public String decodeString(String s) {
        Stack<String> prevSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int k = 0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            } else if(c == '['){
                prevSt.push(sb.toString());
                numSt.push(k);
                k = 0;
                sb = new StringBuilder();
            } else if(c == ']'){
                int count = numSt.pop();
                StringBuilder currStr = new StringBuilder(sb);
                sb = new StringBuilder(prevSt.pop());
                for(int i=0; i<count; i++){
                    sb.append(currStr);
                }

            } else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}