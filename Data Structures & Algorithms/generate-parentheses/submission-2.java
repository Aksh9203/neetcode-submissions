class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        validParenthesis(ans,sb,n,0,0);
        return ans;
    }

    public void validParenthesis(List<String> ans, StringBuilder sb, int n, int openCnt, int closeCnt){
        if(openCnt == n && closeCnt == n){
            ans.add(sb.toString());
            return;
        }

        if(openCnt < n){
            sb.append("(");
            validParenthesis(ans,sb,n,openCnt + 1,closeCnt);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closeCnt < openCnt){
            sb.append(")");
            validParenthesis(ans,sb,n,openCnt,closeCnt + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
