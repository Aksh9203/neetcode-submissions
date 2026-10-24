class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        check(n,ans,sb,0,0);
        return ans;
    }

    private void check(int n, List<String> ans, StringBuilder sb, int openCnt, int closeCnt){
        if(closeCnt == n && openCnt == n){
            ans.add((sb.toString()));
            return;
        }

        if(openCnt < n){
            sb.append("(");
            check(n,ans,sb,openCnt + 1,closeCnt);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closeCnt < openCnt){
            sb.append(")");
            check(n,ans,sb,openCnt,closeCnt + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
