class Solution {
    public String simplifyPath(String path) {
        int n = path.length();

        Stack<String> st = new Stack<>();

        String[] newPath = path.split("/");

        for(String s : newPath){
            if(!st.isEmpty() && s.equals("..")) st.pop();
            else if(st.isEmpty() && s.equals("..")) continue;
            else if(s.equals(".") || s.equals("") ) continue;
            else st.push(s);
        }

        StringBuilder sb = new StringBuilder();

        while(st.size() > 0){
            sb.insert(0,"/" + st.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}